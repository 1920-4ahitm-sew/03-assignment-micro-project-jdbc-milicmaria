package at.htl.adultEducationInstitute.model;

import javax.annotation.processing.Generated;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {

    private Long courseID;          //KursID
    private String courseName;      //Kursname
    private int amountBookings;     //Anzahl von Buchungen

    public Course() {
    }

    public Course(Long courseID, String courseName, int amountBookings) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.amountBookings = amountBookings;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
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
