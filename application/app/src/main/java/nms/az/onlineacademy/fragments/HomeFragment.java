package nms.az.onlineacademy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.activities.CourseListActivity;
import nms.az.onlineacademy.adapters.CourseGridAdapter;
import nms.az.onlineacademy.tools.Utilities;

public class HomeFragment extends Fragment {

    RecyclerView recyclerViewCoursesOnSale, recyclerViewNewCourses;
    RecyclerView recyclerViewTopCoursesDevelopment, recyclerViewTopCoursesEducation;





    private TextView newCoursesButton, coursesOnSaleButton, topCoursesOnDevelopmentButton, topCoursesOnEducationButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CourseGridAdapter courseOnSale = new CourseGridAdapter(getActivity(), Utilities.getCourses(getActivity(),0));




        /*
        * Initialize first horizontal recycler view to show list of courses which are ON SALE right now
        */
        recyclerViewCoursesOnSale = (RecyclerView) view.findViewById(R.id.recycler_view_courses_on_sale);
        recyclerViewCoursesOnSale.setHasFixedSize(true);
        LinearLayoutManager lmCoursesSale
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCoursesOnSale.setLayoutManager(lmCoursesSale);
        recyclerViewCoursesOnSale.setAdapter(new CourseGridAdapter(getActivity(), Utilities.getCourses(getActivity(),1)));
        coursesOnSaleButton = (TextView) view.findViewById(R.id.button_see_all_courses_on_sale);
        coursesOnSaleButton.setOnClickListener(onClick);



        /*
        * Initialize first horizontal recycler view to show list of courses which are NEWLY added to database
        */
        recyclerViewNewCourses = (RecyclerView) view.findViewById(R.id.recycler_view_new_courses);
        recyclerViewNewCourses.setHasFixedSize(true);
        LinearLayoutManager lmNewCourses
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewNewCourses.setLayoutManager(lmNewCourses);
        recyclerViewNewCourses.setAdapter(new CourseGridAdapter(getActivity(), Utilities.getCourses(getActivity(), 2)));
        newCoursesButton = (TextView) view.findViewById(R.id.button_see_all_new_courses);
        newCoursesButton.setOnClickListener(onClick);


        /*
        * Initialize first horizontal recycler view to show list of courses which are TOP
        * courses on DEVELOPMENT category
        */
        recyclerViewTopCoursesDevelopment = (RecyclerView) view.findViewById(R.id.recycler_view_top_courses_development);
        recyclerViewTopCoursesDevelopment.setHasFixedSize(true);
        LinearLayoutManager lmTopCoursesDevelopment
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTopCoursesDevelopment.setLayoutManager(lmTopCoursesDevelopment);
        recyclerViewTopCoursesDevelopment.setAdapter(new CourseGridAdapter(getActivity(), Utilities.getCourses(getActivity(), 3)));
        topCoursesOnDevelopmentButton = (TextView) view.findViewById(R.id.button_see_all_top_courses_development);
        topCoursesOnDevelopmentButton.setOnClickListener(onClick);


        /*
        * Initialize first horizontal recycler view to show list of courses which are TOP
        * courses on EDUCATION category
        */
        recyclerViewTopCoursesEducation = (RecyclerView) view.findViewById(R.id.recycler_view_top_courses_education);
        recyclerViewTopCoursesEducation.setHasFixedSize(true);
        LinearLayoutManager lmTopCoursesEducation
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTopCoursesEducation.setLayoutManager(lmTopCoursesEducation);
        recyclerViewTopCoursesEducation .setAdapter(new CourseGridAdapter(getActivity(), Utilities.getCourses(getActivity(), 1)));
        topCoursesOnEducationButton = (TextView) view.findViewById(R.id.button_see_all_top_courses_education);
        topCoursesOnEducationButton.setOnClickListener(onClick);

        return view;
    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == coursesOnSaleButton) {
                startActivity(new Intent(getActivity(), CourseListActivity.class));
            } else if (view == newCoursesButton)
                startActivity(new Intent(getActivity(), CourseListActivity.class));

        }
    };




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

}
