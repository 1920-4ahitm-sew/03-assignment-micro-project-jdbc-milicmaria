package at.htl.adulteducationinstitute.boundary;

import at.htl.adulteducationinstitute.entity.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostUpdate;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Course getOne(@PathParam("id") long id){
        return em.find(Course.class, id);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAll(){
        return em.createNamedQuery("Course.findAll", Course.class).getResultList();
    }

    @POST
    public void update(Course course){
        em.merge(course);
    }

    @PUT
    @Path("put{id}")
    public Response update(@PathParam("id") Long id, Course c) {
        Course updateCourse = getOne(id);
        updateCourse.setCourseName(c.getCourseName());
        updateCourse.setAmoutBookings(c.getAmoutBookings());

        update(updateCourse);

        return Response.ok().build();
    }

    @POST
    @Path("post")
    public Response create(Course c) {
        create(c);
        return Response.ok().build();
    }

    @DELETE
    @Path("delete{id}")
    public Response delete(@PathParam("id") Long id) {
        Course c = getOne(id);
        delete(id);

        return Response.ok().build();
    }

}
