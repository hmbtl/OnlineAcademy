package nms.az.onlineacademy.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.activities.CourseDetailActivity;
import nms.az.onlineacademy.models.Course;

/**
 * Created by anar on 7/30/15.
 */
public class CourseListAdapter extends ArrayAdapter<Course> {

    private Context context;
    private int resource;
    private List<Course> crses;

    ItemHolder holder;

    public CourseListAdapter(Context context, int resource, List<Course> crses) {
        super(context, resource, crses);

        this.context = context;
        this.resource = resource;
        this.crses = crses;

    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {


        if (row == null) {
            holder = new ItemHolder();

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);

            holder.name = (TextView) row.findViewById(R.id.course_name);
            holder.numberOfStudents = (TextView) row.findViewById(R.id.course_number_of_students);
            holder.image = (ImageView) row.findViewById(R.id.course_image);
            holder.rating = (RatingBar) row.findViewById(R.id.course_rating);

            row.setTag(holder);
        } else
            holder = (ItemHolder) row.getTag();

        Course course = crses.get(position);

        holder.name.setText(course.getName());
        holder.numberOfStudents.setText(String.valueOf(course.getNumberOfStudents()) + " " + context.getResources().getString(R.string.students));


        Picasso.with(context)
                .load(course.getImageURL())
                .centerCrop()
                .into(holder.image);

        Random randomFloat = new Random();
        holder.rating.setRating(randomFloat.nextFloat() * 5.0f);

        return row;
    }

    @Override
    public int getCount() {
        return crses.size();
    }

    @Override
    public Course getItem(int position) {
        return crses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ItemHolder {
        ImageView image;
        TextView  numberOfStudents, name;
        RatingBar rating;
    }

}
