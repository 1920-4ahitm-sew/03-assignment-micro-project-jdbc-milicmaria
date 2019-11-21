package at.htl.adulteducationinstitute.control;

import at.htl.adulteducationinstitute.entity.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
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
import java.util.stream.Stream;

@ApplicationScoped
@Transactional
public class InitBean {

    private static final String COURSES_FILE = "courses.csv";

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init){
//        em.persist(new Course("Englisch A2", 19));
//        em.persist(new Course("Deutsch B1", 13));

        importedCourses(COURSES_FILE);
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
                    .map(line -> new Course(line[0], Integer.parseInt(line[1])))
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

}
