package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.dto.CityInsertDTO;
import gr.aueb.cf.schoolapp.dto.CityUpdateDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;

import java.util.HashMap;
import java.util.Map;

public class CityValidator {
    private CityValidator() {}

    public static Map<String, String> validate(CityInsertDTO dto) {
        Map<String, String> errors = new HashMap<>();

        // City Name Validations
        String name = dto.getName();
        if (name == null || name.trim().isEmpty()) {
            errors.put("name", "City name must be provided.");
        }

        if (dto.getName().matches("^.*\\s+.*$")) {
            errors.put("firstname", "whitespaces");
        }

        return errors;
    }

    public static Map<String, String> validate(CityUpdateDTO dto) {
        Map<String, String> errors = new HashMap<>();
        if (dto.getName().length() < 3 || dto.getName().length() > 32) {
            errors.put("firstname", "size");
        }

        if (dto.getName().matches("^.*\\s+.*$")) {
            errors.put("firstname", "whitespaces");
        }

        return errors;
    }
}
