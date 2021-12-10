package com.example.schoolnotes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    // include all the buttons id
    final private int [] ButtonRes = new int [] {R.id.s390f, R.id.a309bf, R.id.s496f, R.id.s413f, R.id.a310bf };
    CoursesList coursesList;
    Course[] courses;
    View [] upComing;


    private Activity mActivity;
    private SharedPreferences mSharedPreferences;
    private TextView upcomingCoursesText, myCoursesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);
        myToolbar.inflateMenu(R.menu.top_app_bar);

        //Setting courses array
        coursesList = new CoursesList();
        courses = coursesList.getCourseArray();

        //Create schedule view
        Thread thread = new Thread(runnable);
        thread.start();

        //Setting shared preferences for title color setting
        mActivity = MainActivity.this;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mActivity);
        upcomingCoursesText = findViewById(R.id.textView_Upcoming);
        myCoursesText = findViewById(R.id.textView_myCourses);


    }

        private Runnable runnable = new Runnable() {
            @Override
            public void run() {
                createSchedule();

            }
        };

    @Override
    protected void onResume() {
        super.onResume();

        String textColor = mSharedPreferences.getString(
                getString(R.string.text_color_key),
                getString(R.string.text_color_default));
        upcomingCoursesText.setTextColor(Color.parseColor(textColor));
        myCoursesText.setTextColor(Color.parseColor(textColor));


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
                Intent aboutIntent = new Intent(MainActivity.this,About.class);
                startActivity(aboutIntent);
                return true;

            case R.id.setting:
                // User chose the "Settings" item, show the app settings UI...
                Intent settingIntent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(settingIntent);
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
                Intent intent = new Intent(MainActivity.this, CourseAssignmentActivity.class);
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
