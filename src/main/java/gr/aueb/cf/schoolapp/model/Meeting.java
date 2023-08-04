package gr.aueb.cf.schoolapp.model;

import java.sql.Date;

public class Meeting {
    private Integer id;
    private int teacherId;
    private int studentId;
    private String room;

    private java.sql.Date meetingDate;

    public Meeting() {}

    public Meeting(Integer id, int teacherId, int studentId, String room, java.sql.Date meetingDate) {
        this.id = id;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.room = room;
        this.meetingDate = meetingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(java.sql.Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", studentId=" + studentId +
                ", room='" + room + '\'' +
                ", meetingDate=" + meetingDate +
                '}';
    }
}
