package at.htl.adulteducationinstitute.entity;

import javax.persistence.*;

@Entity
@Table(name="COURSE")
@NamedQueries(
        @NamedQuery(
                name = "Course.findAll",
                query = "select c from Course c"
        )
)

public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String grade;
    private int amoutBookings;
    @ManyToOne
    private Lecturer lecturer;

    public Course() {
    }

    public Course(String courseName, String grade, int amoutBookings) {
        this.courseName = courseName;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Lecturer getLecturer() { return lecturer; }

    public void setLecturer(Lecturer lecturer) { this.lecturer = lecturer; }

    @Override
    public String toString() {
        return String.format("%d: %s %d", id, courseName, amoutBookings);
    }
}
