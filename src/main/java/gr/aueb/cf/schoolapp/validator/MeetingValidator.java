package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.dto.MeetingInsertDTO;
import gr.aueb.cf.schoolapp.dto.MeetingUpdateDTO;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MeetingValidator {

    public static Map<String, String> validate(MeetingInsertDTO dto) {
        Map<String, String> errors = new HashMap<>();

        // Room Validations
        String room = dto.getRoom();
        if (room == null || room.trim().isEmpty()) {
            errors.put("room", "Room name cannot be empty");
        }

        // Meeting Date Validations
        java.sql.Date meetingDateSql = dto.getMeetingDate();
        if (meetingDateSql == null) {
            errors.put("meetingDate", "Meeting date cannot be empty");
        } else {
            LocalDate meetingDate = meetingDateSql.toLocalDate();
            LocalDate currentDate = LocalDate.now();
            if (meetingDate.isBefore(currentDate)) {
                errors.put("meetingDate", "Meeting date cannot be earlier than the current date");
            }
        }

        return errors;
    }

    public static Map<String, String> validate(MeetingUpdateDTO dto) {
        Map<String, String> errors = new HashMap<>();

        // Room Validations
        String room = dto.getRoom();
        if (room == null || room.trim().isEmpty()) {
            errors.put("room", "Room name cannot be empty");
        }

        // Meeting Date Validations
        java.sql.Date meetingDateSql = dto.getMeetingDate();
        if (meetingDateSql == null) {
            errors.put("meetingDate", "Meeting date cannot be empty");
        } else {
            LocalDate meetingDate = meetingDateSql.toLocalDate();
            LocalDate currentDate = LocalDate.now();
            if (meetingDate.isBefore(currentDate)) {
                errors.put("meetingDate", "Meeting date cannot be earlier than the current date");
            }
        }

        return errors;
    }
}
