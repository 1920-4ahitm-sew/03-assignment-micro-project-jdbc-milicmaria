package at.htl.adulteducationinstitute.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lecturer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String street;
    private int houseNo;
    private int zipCode;
    private String town;
    private Date hireDate;
    @ManyToOne
    private Subject subject;

    public Lecturer() {
    }

    public Lecturer(String firstname, String lastname, String street, int houseNo, int zipCode, String town, Date hireDate, Subject subject) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.houseNo = houseNo;
        this.zipCode = zipCode;
        this.town = town;
        this.hireDate = hireDate;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
