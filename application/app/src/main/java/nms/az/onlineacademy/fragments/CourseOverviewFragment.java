package nms.az.onlineacademy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.activities.CourseLearnActivity;
import nms.az.onlineacademy.models.Course;
import nms.az.onlineacademy.tools.Constants;
import nms.az.onlineacademy.tools.Utilities;

/**
 * Created by anar on 8/13/15.
 */
public class CourseOverviewFragment extends Fragment {

    private Course course;
    public static final String COURSE_ID = "COURSE_ID_KEY";

    public static CourseOverviewFragment createInstance(int courseId) {
        CourseOverviewFragment courseOverviewFragment = new CourseOverviewFragment();

        Bundle data = new Bundle();
        data.putInt(COURSE_ID, courseId);
        courseOverviewFragment.setArguments(data);
        return courseOverviewFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NestedScrollView scrollView = (NestedScrollView) inflater.inflate(
                R.layout.fragment_course_overview, container, false);
        Button download = (Button) scrollView.findViewById(R.id.course_download_button);

        Bundle data = getArguments();
        course = Utilities.getCourse(getActivity(), data.getInt(COURSE_ID));

        TextView content = (TextView) scrollView.findViewById(R.id.content_overview);

        content.setText(course.getChapters().get(0).getContent());

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CourseLearnActivity.class);
                intent.putExtra(Constants.COURSE_ID_KEY, course.getId());
                startActivity(intent);
            }
        });

        return scrollView;
    }


}
