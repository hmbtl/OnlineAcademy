package nms.az.onlineacademy.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;

import me.relex.circleindicator.CircleIndicator;
import nms.az.onlineacademy.R;
import nms.az.onlineacademy.fragments.CourseChaptersFragment;
import nms.az.onlineacademy.models.Chapter;
import nms.az.onlineacademy.models.Course;
import nms.az.onlineacademy.tools.Constants;
import nms.az.onlineacademy.tools.Utilities;

/**
 * Created by anar on 9/28/15.
 */
public class CourseLearnActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    private int courseId;

    private Course course;


    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    private Chapter chapter;

    private int chpIndex = 0;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_learn);

        Bundle data = getIntent().getExtras();
        courseId = data.getInt(Constants.COURSE_ID_KEY);
        course = Utilities.getCourse(this, courseId);
        chpIndex = data.getInt("position");
        chapter = course.getChapters().get(chpIndex);


        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new FlipHorizontalTransformer());


        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);
        defaultIndicator.setViewPager(mPager);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public Chapter getChapter() {
        return chapter;
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return CourseChaptersFragment.createInstance(position, chpIndex);
        }

        @Override
        public int getCount() {
            return chapter.getSlides().size();
        }
    }
}
