package at.htl.adulteducationinstitute.boundary;

import at.htl.adulteducationinstitute.entity.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Stateless
@Path("/")
public class CourseEndpoint {
    @PersistenceContext
    EntityManager em;

    public void init(){
        System.out.println("*****COURSEENDPOINT CREATED*****");
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Course getEnglisch(@PathParam("id") long id){
        return em.find(Course.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAll(){
        return em.createNamedQuery("Course.findAll", Course.class).getResultList();
    }


}
