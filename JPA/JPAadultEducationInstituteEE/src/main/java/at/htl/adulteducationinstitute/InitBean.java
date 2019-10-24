package at.htl.adulteducationinstitute;

import at.htl.adulteducationinstitute.entity.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InitBean {

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init){
        em.persist(new Course("Englisch A2", 19));
        em.persist(new Course("Deutsch B1", 13));
    }

    public void tearDown(@Observes @Destroyed(ApplicationScoped.class) Object init){

    }

}
