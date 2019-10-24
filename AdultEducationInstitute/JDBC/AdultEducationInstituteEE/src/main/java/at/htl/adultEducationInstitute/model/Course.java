package at.htl.adultEducationInstitute.model;

import javax.annotation.processing.Generated;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {

    private Long id;                //KursID
    private String courseName;      //Kursname
    private int amountBookings;     //Anzahl von Buchungen

    public Course() {
    }

    public Course(Long id, String courseName, int amountBookings) {
        this.id = id;
        this.courseName = courseName;
        this.amountBookings = amountBookings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
