package at.htl.adultEducationInstitute.rest;

import at.htl.adultEducationInstitute.model.Course;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("course")
public class CourseEndpoint {

    @GET
    @Path("{id}")
    public Course find(@PathParam("id") Long id){
        return new Course(id, "Englisch für Anfänger", 25);
    }

    @GET
    @Path("findAll")
    public List<Course> findAll(){
        List<Course> all = new ArrayList<>();
        all.add(find((long) 1));
        return all;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id){
        System.out.println("deleted " + id);
    }

    @POST
    public void save(Course course){
        System.out.println("Course = " + course);
    }


}
