package nms.az.onlineacademy.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.activities.CourseDetailActivity;
import nms.az.onlineacademy.models.Course;
import nms.az.onlineacademy.tools.Constants;

/**
 * Created by anar on 7/24/15.
 */
public class CourseGridAdapter extends RecyclerView.Adapter<CourseGridAdapter.ViewHolder> {

    public  List<Course> crses;
    public  Context context;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, numberOfStudents;
        public ImageView image;
        public RatingBar rating;
        public CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.course_name);
//            discountedPrice = (TextView) itemView.findViewById(R.id.course_price_discounted);
            numberOfStudents = (TextView) itemView.findViewById(R.id.course_number_of_students);
            image = (ImageView) itemView.findViewById(R.id.course_image);
//            rating = (RatingBar) itemView.findViewById(R.id.course_rating);
//            cardview = (CardView) itemView.findViewById(R.id.card_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (crses.get(getAdapterPosition()).getChapters() != null) {
                Log.e("CoursesClicked",String.valueOf(getAdapterPosition()));
                Intent intent = new Intent(context, CourseDetailActivity.class);
                Log.e("course", crses.get(getAdapterPosition()).getName());
                intent.putExtra(Constants.COURSE_ID_KEY, crses.get(getAdapterPosition()).getId());
                context.startActivity(intent);
            }
        }
    }

    public CourseGridAdapter(Context context, List<Course> crses) {
        this.context = context;
        this.crses = crses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item_course_grid, viewGroup, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Course course = crses.get(position);

        viewHolder.name.setText(course.getName());
//        viewHolder.discountedPrice.setText("AZN " + String.valueOf(course.getDiscountedPrice()));
        viewHolder.numberOfStudents.setText(String.valueOf(course.getNumberOfStudents()) + " " + context.getResources().getString(R.string.students));


        Random randomFloat = new Random();
//        viewHolder.rating.setRating(randomFloat.nextFloat() * 5.0f);


        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));



        Picasso.with(context)
                .load(course.getImageResource())
                .into(viewHolder.image);
        viewHolder.image.setBackgroundColor(color);


//        if (position == 5) {
//            float scale = context.getResources().getDisplayMetrics().density;
//            int paddingRight = (int) (5 * scale + 0.5f);
//
//            LayoutParams params = new LayoutParams(
//                    LayoutParams.WRAP_CONTENT,
//                    LayoutParams.WRAP_CONTENT
//            );
//
//            viewHolder.cardview.setLa(viewHolder.cardview.getContentPaddingLeft(),
//                    viewHolder.cardview.getContentPaddingTop(), paddingRight, viewHolder.cardview.getPaddingBottom());
//        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return crses.size();
    }
}