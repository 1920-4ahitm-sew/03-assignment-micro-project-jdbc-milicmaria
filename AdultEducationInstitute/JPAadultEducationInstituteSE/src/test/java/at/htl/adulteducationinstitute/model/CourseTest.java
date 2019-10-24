package at.htl.adulteducationinstitute.model;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.zip.CheckedOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class CourseTest {

    static EntityManager em;

    @BeforeAll
    private static void init(){
        em = Persistence
                .createEntityManagerFactory("myPU").
                createEntityManager();
    }
s
    @Test
    void test01DBConnection(){
        Course englisch = new Course("Englisch A2", 19);
        em.getTransaction().begin();
        em.persist(englisch);
        em.getTransaction().commit();
    }

    @Test
    void test02readOneCourse(){
        Course englisch = em.find(Course.class, 1L);
        assertThat(englisch.getCourseName(), is("Englisch A2"));
        assertThat(englisch.getAmountBookings(), is(19));
    }

}
