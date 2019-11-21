package at.htl.adulteducationinstitute.control;

import at.htl.adulteducationinstitute.entity.Course;
import at.htl.adulteducationinstitute.entity.Lecturer;
import at.htl.adulteducationinstitute.entity.Subject;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;

@ApplicationScoped
@Transactional
public class InitBean {

    private static final String COURSES_FILE = "courses.csv";
    private static final String LECTURER_FILE = "lecturers.csv";

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init){
//        em.persist(new Course("Englisch A2", 19));
//        em.persist(new Course("Deutsch B1", 13));

        importedCourses(COURSES_FILE);
        importLecturersAndSubjects(LECTURER_FILE);
    }

    public void importedCourses(String coursesFile){
        /*new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("/" + coursesFile), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(rows -> new Course(rows[0], Integer.parseInt(rows[1])))
                .forEach(em::merge);
        */

        URL url = Thread.currentThread().getContextClassLoader()
                .getResource(coursesFile);
        try (Stream<String> stream = Files.lines(Paths.get(url.getPath()), StandardCharsets.UTF_8)) {
            stream.skip(1)
                    .map(s -> s.split(";"))
                    .map(line -> new Course(line[0], line[1], Integer.parseInt(line[2])))
                    .forEach(em::merge);
//            String[] rows = url.getFile().split(";");
//            Course c = new Course();
//            c.setCourseName(rows[1]);
//            c.setAmoutBookings(Integer.parseInt(rows[2]));
//            em.persist(c);
//            stream.forEach(em::merge);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importLecturersAndSubjects(String lecturersfile){
        URL url = Thread.currentThread().getContextClassLoader()
                .getResource(lecturersfile);
        try (Stream<String> stream = Files.lines(Paths.get(url.getPath()), StandardCharsets.UTF_8)) {
            stream.skip(1)
                    .map(s -> s.split(";"))
                    .forEach(this::persistLecturersAndSubjects);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void persistLecturersAndSubjects(String rows[]){
        Subject subject = null;
        try {
            subject = em
                    .createQuery("select s from Subject s where s.name = :NAME", Subject.class)
                    .setParameter("NAME", rows[7])
                    .getSingleResult();
        } catch (NoResultException e){
            subject = new Subject(rows[7]);
            em.persist(subject);
        }
        try {
            em.persist(new Lecturer(rows[0], rows[1], rows[2], Integer.parseInt(rows[3]),
                    rows[4], rows[5], new SimpleDateFormat("dd-MM-yyyy").parse(rows[6]), subject));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
