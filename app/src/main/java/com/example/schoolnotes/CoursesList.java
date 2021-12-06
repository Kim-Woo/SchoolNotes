package com.example.schoolnotes;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class CoursesList {

    //create list of courses
    private List<Course> courseList = new ArrayList<Course>();
    private Course [] courses;

    //Create courses into courseList
    public CoursesList(){
        Course course;

        course = new Course("COMP S390F","Creative Programming","kwtse", DayOfWeek.FRIDAY, Time.valueOf("09:00:00"), "HKMU C0910",
                DayOfWeek.MONDAY, Time.valueOf("09:00:00"), "JCPC D0617");
        course.addAssignments(new Assignment("Project Interim Report","28-11-2021"));
        course.addAssignments(new Assignment("Demonstration","13-12-2021"));
        courseList.add(course);

        course = new Course("AMVE A309BF","Media Management","JosephWong", DayOfWeek.TUESDAY,Time.valueOf("14:00:00"),"IOH F0821",
                DayOfWeek.TUESDAY,Time.valueOf("16:00:00"),"IOH F0821" );
        course.addAssignments(new Assignment("Presentation","07-12-2021"));
        course.addAssignments(new Assignment("Final Report","17-12-2021"));
        courseList.add(course);

        course = new Course("COMP S496F","Interactive Application","alui",DayOfWeek.THURSDAY, Time.valueOf("11:00:00"),"HKMU C0311",
                DayOfWeek.THURSDAY,Time.valueOf("11:00:00"),"HKMU C0311");
        course.addAssignments(new Assignment("Progress Reports","12-12-2021"));
        course.addAssignments(new Assignment("Interim Report","11-02-2022"));
        courseList.add(course);

        course = new Course("COMP S413F","Application Design","kwtse" ,DayOfWeek.FRIDAY, Time.valueOf("14:00:00"),"HKMU B0614",
                DayOfWeek.TUESDAY,Time.valueOf("11:00:00"),"MUPC C0413");
        course.addAssignments(new Assignment("Project Demo","14-12-2021"));
        course.addAssignments(new Assignment("Test 2","17-12-2021"));
        courseList.add(course);

        course = new Course("AMVE A310BF","Sound Design And Visual Effects","wcflai",DayOfWeek.WEDNESDAY, Time.valueOf("09:00:00"),"School Lab E0413",
                DayOfWeek.WEDNESDAY,Time.valueOf("11:00:00"),"School Lab E0413");
        course.addAssignments(new Assignment("Project Demo","22-12-2021"));
        course.addAssignments(new Assignment("Presentation","22-12-2021"));
        courseList.add(course);

        courses = new Course[courseList.size()];
        courseList.toArray(courses);
    }

    //return course list
    public Course[] getCourseArray() {
        return courses;
    }
}
