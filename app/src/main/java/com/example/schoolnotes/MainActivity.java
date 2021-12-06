package com.example.schoolnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // include all the buttons id
    final private int [] ButtonRes = new int [] {R.id.s390f, R.id.a309bf, R.id.s496f, R.id.s413f, R.id.a310bf };
    CoursesList coursesList;
    Course[] courses;

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

    private void createSchedule() {

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
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.setting:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
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


}