package com.example.schoolnotes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class CourseAssignmentActivity extends AppCompatActivity {

    public static final String TheCourse = "Key1";

    private TextView assignmentText;

    private Activity mActivity;
    private SharedPreferences mSharedPreferences;  //save

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_assignment);

        assignmentText = findViewById(R.id.textView_Assignment);
        mActivity = CourseAssignmentActivity.this;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mActivity); //save

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
    }

    @Override
    protected void onResume() {
        super.onResume();


        String textColor = mSharedPreferences.getString(
                getString(R.string.text_color_key),
                getString(R.string.text_color_default));
        assignmentText.setTextColor(Color.parseColor(textColor));



    }
}