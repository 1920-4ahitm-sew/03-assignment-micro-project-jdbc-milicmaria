package at.htl.adulteducationinstitute.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {

    private Long id;
    private String courseName;
    private int amoutBookings;

    public Course() {
    }

    public Course(String courseName, int amoutBookings) {
        this.courseName = courseName;
        this.amoutBookings = amoutBookings;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAmoutBookings() {
        return amoutBookings;
    }

    public void setAmoutBookings(int amoutBookings) {
        this.amoutBookings = amoutBookings;
    }
}
