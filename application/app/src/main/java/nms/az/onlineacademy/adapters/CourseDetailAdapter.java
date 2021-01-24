package nms.az.onlineacademy.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import nms.az.onlineacademy.tools.Constants;

/**
 * Created by anar on 8/13/15.
 */
public class CourseDetailAdapter extends FragmentPagerAdapter {

    public CourseDetailAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        Bundle args = new Bundle();
        args.putInt(Constants.POSITION_KEY, position);
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
