package at.htl.adulteducationinstitute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Course implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int amountBookings;

    public Course() {
    }

    public Course(String courseName, int amountBookings) {
        this.courseName = courseName;
        this.amountBookings = amountBookings;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAmountBookings() {
        return amountBookings;
    }

    public void setAmountBookings(int amountBookings) {
        this.amountBookings = amountBookings;
    }
}
