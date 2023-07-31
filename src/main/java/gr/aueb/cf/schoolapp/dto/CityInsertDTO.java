package gr.aueb.cf.schoolapp.dto;

public class CityInsertDTO {
    private String name;

    public CityInsertDTO() {
    }

    public CityInsertDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
