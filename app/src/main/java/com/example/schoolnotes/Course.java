package com.example.schoolnotes;

import java.io.Serializable;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String courseLecturerName;
    private DayOfWeek lectureWeekDay;
    private Time lectureTime;
    private String lectureLocation;
    private DayOfWeek tutorialWeekDay;
    private Time tutorialTime;
    private String tutorialLocation;
    private List<Assignment> assignments;


    //constructor
    public Course (String courseCode, String courseName, String courseLecturerName, DayOfWeek lectureWeekDay,Time lectureTime, String lectureLocation,
            DayOfWeek tutorialWeekDay, Time tutorialTime, String tutorialLocation){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseLecturerName = courseLecturerName;
        this.lectureWeekDay = lectureWeekDay;
        this.lectureTime = lectureTime;
        this.lectureLocation = lectureLocation;
        this.tutorialWeekDay = tutorialWeekDay;
        this.tutorialTime = tutorialTime;
        this.tutorialLocation = tutorialLocation;
        assignments = new ArrayList<>();
    }

    public Course(){}

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLecturerName() {
        return courseLecturerName;
    }


    public DayOfWeek getLectureWeekDay() {
        return lectureWeekDay;
    }

    public Time getLectureTime() {
        return lectureTime;
    }

    public String getLectureLocation() {
        return lectureLocation;
    }

    public DayOfWeek getTutorialWeekDay() {
        return tutorialWeekDay;
    }

    public Time getTutorialTime() {
        return tutorialTime;
    }

    public String getTutorialLocation() {
        return tutorialLocation;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addAssignments(Assignment assignment) {
        this.assignments.add(assignment);
    }
}
