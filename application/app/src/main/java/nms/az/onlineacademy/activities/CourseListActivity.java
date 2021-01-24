package nms.az.onlineacademy.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.adapters.CourseListAdapter;
import nms.az.onlineacademy.tools.Utilities;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by anar on 7/30/15.
 */
public class CourseListActivity extends AppCompatActivity {

    private CourseListAdapter adapter;
    private ListView courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            toolbar.setTitle(R.string.courses_on_sale);
        }

        courseList = (ListView) findViewById(R.id.course_list_course_categories);
        adapter = new CourseListAdapter(this, R.layout.adapter_item_course_list, Utilities.getCourses(this,0));

        courseList.setAdapter(adapter);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
