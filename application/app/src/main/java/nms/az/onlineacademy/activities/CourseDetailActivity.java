package nms.az.onlineacademy.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.models.Chapter;
import nms.az.onlineacademy.models.Course;
import nms.az.onlineacademy.tools.Constants;
import nms.az.onlineacademy.tools.Utilities;

/**
 * Created by anar on 7/31/15.
 */
public class CourseDetailActivity extends AppCompatActivity {


    Course course;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);



        Bundle data = getIntent().getExtras();
        course = Utilities.getCourse(this, data.getInt(Constants.COURSE_ID_KEY));


        Log.e("Course", String.valueOf(data.getInt(Constants.COURSE_ID_KEY)));

        ListView chapterlist = (ListView) findViewById(R.id.chapter_list);
        chapterlist.setAdapter(new CourseDetailAdapter(this, R.layout.adapter_item_course_chapter_list, course.getChapters()));


        ImageView courseImage = (ImageView) findViewById(R.id.course_image);


        Picasso.with(CourseDetailActivity.this)
                .load(course.getImageResource())
                .into(courseImage);





        chapterlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CourseDetailActivity.this, CourseLearnActivity.class);
                intent.putExtra("position", position);
                intent.putExtra(Constants.COURSE_ID_KEY, course.getId());
                startActivity(intent);
            }
        });
    }


    private class CourseDetailAdapter extends ArrayAdapter<Chapter> {

        private List<Chapter> chapters = new LinkedList<>();


        private int resource;
        private LayoutInflater inflater;
        private Context context;

        ViewHolder holder;

        public CourseDetailAdapter(Context context, int resource, List<Chapter> chapters) {
            super(context, resource, chapters);

            this.context = context;
            this.chapters = chapters;
            this.inflater = LayoutInflater.from(context);
            this.resource = resource;
        }

        @Override
        public int getCount() {
            return chapters.size();
        }


        @Override
        public Chapter getItem(int position) {
            return chapters.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {

                holder = new ViewHolder();
                convertView = inflater.inflate(resource, parent, false);

                holder.name = (TextView) convertView.findViewById(R.id.chapter_title);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            holder.name.setText((position + 1) + ". " + chapters.get(position).getTitle());

            int color;

            switch (position) {
                case 0:
                    color = ContextCompat.getColor(context, R.color.slide_1);
                    break;
                case 1:
                    color = ContextCompat.getColor(context, R.color.slide_2);
                    break;
                case 2:
                    color = ContextCompat.getColor(context, R.color.slide_3);
                    break;
                case 3:
                    color = ContextCompat.getColor(context, R.color.slide_4);
                    break;
                case 4:
                    color = ContextCompat.getColor(context, R.color.slide_5);
                    break;
                case 5:
                    color = ContextCompat.getColor(context, R.color.slide_6);
                    break;
                case 6:
                    color = ContextCompat.getColor(context, R.color.slide_1);
                    break;
                case 7:
                    color = ContextCompat.getColor(context, R.color.slide_2);
                    break;
                case 8:
                    color = ContextCompat.getColor(context, R.color.slide_3);
                    break;
                case 9:
                    color = ContextCompat.getColor(context, R.color.slide_4);
                    break;
                case 10:
                    color = ContextCompat.getColor(context, R.color.slide_5);
                    break;
                case 11:
                    color = ContextCompat.getColor(context, R.color.slide_6);
                    break;
                case 12:
                    color = ContextCompat.getColor(context, R.color.slide_1);
                    break;
                default:
                    color = ContextCompat.getColor(context, R.color.slide_2);
                    break;
            }


            holder.name.setBackgroundColor(color);

            return convertView;
        }

        class ViewHolder {
            TextView name;
        }
    }


}
