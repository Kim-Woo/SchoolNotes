package com.example.schoolnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // include all the buttons id
    final private int [] ButtonRes = new int [] {R.id.s390f, R.id.a309bf, R.id.s496f, R.id.s413f, R.id.a310bf };
    CoursesList coursesList;
    Course[] courses;
    View [] upComing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);
        myToolbar.inflateMenu(R.menu.top_app_bar);

        coursesList = new CoursesList();
        courses = coursesList.getCourseArray();

        createSchedule();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.top_app_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                //User chose the "About" item, show the about page...
                Intent intent = new Intent(MainActivity.this,About.class);
                startActivity(intent);
                return true;

            case R.id.setting:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    public void handleButton(View button) {
        int buttonId = button.getId();
        for (int i=0; i<courses.length;i++) {
            Course theCourse = courses[i];
            if (buttonId == ButtonRes[i]) {

                Bundle bundle = new Bundle();
                bundle.putSerializable("TheCourse", theCourse);
                //start intent
                Intent intent = new Intent(MainActivity.this, CourseAssignmentIntentActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        }
    }

    private void createSchedule() {
        upComing = new View[3];
        upComing[0] = findViewById(R.id.upcoming_1);
        upComing[1] = findViewById(R.id.upcoming_2);
        upComing[2] = findViewById(R.id.upcoming_3);

        TextView [] courseCode = new TextView[3];
        TextView [] courseTime = new TextView[3];
        TextView [] lecturer = new TextView[3];
        TextView [] location = new TextView[3];

        Course[] theCourses = new Course[3];
        theCourses[0] = courses[3];
        theCourses[1] = courses[1];
        theCourses[2] = courses[1];
        for (int i=0; i<upComing.length;i++){
            courseCode[i] = upComing[i].findViewById(R.id.uc_courseCode);
            courseTime[i] = upComing[i].findViewById(R.id.uc_courseTime);
            lecturer[i] = upComing[i].findViewById(R.id.uc_courseLecturerName);
            location[i] = upComing[i].findViewById(R.id.uc_courseLocation);

            courseCode[i].setText(theCourses[i].getCourseCode());
            courseTime[i].setText(theCourses[i].getTutorialWeekDay()+" "+theCourses[i].getTutorialTime());
            lecturer[i].setText(theCourses[i].getCourseLecturerName());
            location[i].setText(theCourses[i].getTutorialLocation());

            if (i==1){
                courseTime[i].setText(theCourses[i].getLectureWeekDay()+" "+theCourses[i].getLectureTime());
            }
        }

    }

}
