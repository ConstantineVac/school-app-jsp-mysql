package gr.aueb.cf.schoolapp.dto;

public class TeacherDeleteDTO extends Base {
    private String firstname;
    private String lastname;
    private Integer specialtyId;


    public TeacherDeleteDTO() {}

    public TeacherDeleteDTO(int id, String firstname, String lastname, Integer specialtyId) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialtyId = specialtyId;
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

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }
}
