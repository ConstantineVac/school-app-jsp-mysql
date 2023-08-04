package gr.aueb.cf.schoolapp.dto;

import java.sql.Date;

public class MeetingInsertDTO {


    private int teacherId;
    private int studentId;
    private String room;
    private java.sql.Date meetingDate;

    public MeetingInsertDTO() {}

    public MeetingInsertDTO(int teacherId, int studentId, String room, java.sql.Date meetingDate) {
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.room = room;
        this.meetingDate = meetingDate;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public java.sql.Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }
}
