package gr.aueb.cf.schoolapp.dto;

import java.sql.Date;

public class StudentUpdateDTO extends Base{
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private java.sql.Date birthdate;

    public StudentUpdateDTO() {}

    public StudentUpdateDTO(Integer id, String firstname, String lastname, String gender, Date birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
