package nms.az.onlineacademy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.activities.CourseLearnActivity;
import nms.az.onlineacademy.models.Chapter;
import nms.az.onlineacademy.models.Slide;

/**
 * Created by anar on 9/28/15.
 */
public class CourseChaptersFragment extends Fragment {


    public static final String ITEMS_COUNT_KEY = "ITEMS_COUNT_KEY";
    public static final String CHAPTER_INDEX = "CHAPTER_INDEX";
    private TextView content;
    private ImageView image;
    private Chapter chapter;
    private CourseLearnActivity activity;



    public static CourseChaptersFragment createInstance(int itemsCount, int index) {
        CourseChaptersFragment courseContentsFragment = new CourseChaptersFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        bundle.putInt(CHAPTER_INDEX, index);
        courseContentsFragment.setArguments(bundle);
        return courseContentsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_course_chapters, container, false);


        Bundle bundle = getArguments();
        int position = bundle.getInt(ITEMS_COUNT_KEY);
        int index = bundle.getInt(CHAPTER_INDEX);

        TextView title = (TextView) rootView.findViewById(R.id.chapter_title);
        TextView content = (TextView) rootView.findViewById(R.id.chapter_content);

        activity = (CourseLearnActivity) getActivity();

        chapter = activity.getChapter();

        Slide slide = chapter.getSlides().get(position);



        title.setText(slide.getTitle());
        content.setText(slide.getBody());


        content = (TextView) rootView.findViewById(R.id.chapter_content);


        int color;

        switch (index) {
            case 0:
                color = ContextCompat.getColor(getContext(), R.color.slide_1);
                break;
            case 1:
                color = ContextCompat.getColor(getContext(), R.color.slide_2);
                break;
            case 2:
                color = ContextCompat.getColor(getContext(), R.color.slide_3);
                break;
            case 3:
                color = ContextCompat.getColor(getContext(), R.color.slide_4);
                break;
            case 4:
                color = ContextCompat.getColor(getContext(), R.color.slide_5);
                break;
            case 5:
                color = ContextCompat.getColor(getContext(), R.color.slide_6);
                break;
            case 6:
                color = ContextCompat.getColor(getContext(), R.color.slide_1);
                break;
            case 7:
                color = ContextCompat.getColor(getContext(), R.color.slide_2);
                break;
            case 8:
                color = ContextCompat.getColor(getContext(), R.color.slide_3);
                break;
            case 9:
                color = ContextCompat.getColor(getContext(), R.color.slide_4);
                break;
            case 10:
                color = ContextCompat.getColor(getContext(), R.color.slide_5);
                break;
            case 11:
                color = ContextCompat.getColor(getContext(), R.color.slide_6);
                break;
            case 12:
                color = ContextCompat.getColor(getContext(), R.color.slide_1);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.slide_2);
                break;
        }

        title.setBackgroundColor(color);

        return rootView;
    }



}
