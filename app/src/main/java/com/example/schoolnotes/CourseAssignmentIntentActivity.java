package com.example.schoolnotes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CourseAssignmentIntentActivity extends AppCompatActivity {

    public static final String TheCourse = "Key1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_assignment);

        Course theCourse;
        theCourse = (Course) getIntent().getSerializableExtra("TheCourse");

        Assignment a1, a2;
        a1 = theCourse.getAssignments().get(0);
        a2 = theCourse.getAssignments().get(1);

        TextView name = findViewById(R.id.CourseName);
        name.setText(theCourse.getCourseName());

        TextView assignment1 = findViewById(R.id.assignment1);
        assignment1.setText(a1.getTitle()+ "\n" +"Due Date: "+a1.getDueDate());

        TextView assignment2 = findViewById(R.id.assignment2);
        assignment2.setText(a2.getTitle()+ "\n" +"Due Date: "+a2.getDueDate());

//
//        String courseTitle = getIntent().getStringExtra(CourseTitle);
//        String a1Title = getIntent().getStringExtra(A1Title);
//        String a1DueDate = getIntent().getStringExtra(A1DueDate);
//        String a2Title = getIntent().getStringExtra(A2Title);
//        String a2DueDate = getIntent().getStringExtra(A2DueDate);
//
//        TextView name = findViewById(R.id.CourseName);
//        name.setText(courseTitle);
//
//        TextView assignment1 = findViewById(R.id.assignment1);
//        assignment1.setText(a1Title+ "\n" +"Due Date: "+a1DueDate);
//
//        TextView assignment2 = findViewById(R.id.assignment2);
//        assignment2.setText(a2Title+ "\n" +"Due Date: "+a2DueDate);
    }
}