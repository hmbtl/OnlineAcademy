package nms.az.onlineacademy.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.adapters.CategoryListAdapter;
import nms.az.onlineacademy.adapters.CourseGridAdapter;
import nms.az.onlineacademy.tools.Utilities;

/**
 * Created by anar on 7/31/15.
 */
public class CategoryFragment extends Fragment {

    private ListView categoryList;
    private RecyclerView popularCoursesRecyclerView;

    CourseGridAdapter courseAdapter;
    CategoryListAdapter categoryListAdapter;

    private List<String> subCategories;

    private String category;
    private int catId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category,
                container, false);


        Bundle args = getArguments();

        category = args.getString("category");
        catId = args.getInt("catId");

        initSubCategories(category);


        // Initialize list view to show categories
        categoryList = (ListView) view.findViewById(R.id.list_view_category);

        categoryListAdapter = new CategoryListAdapter(getActivity(), R.layout.adapter_item_subcategory, subCategories);
        categoryList.setAdapter(categoryListAdapter);

        // Initialize header view of categoryList
        View header = getActivity().getLayoutInflater().inflate(R.layout.adapter_header_category_list, null);
        categoryList.addHeaderView(header);

        // Recycler is child view of header
        popularCoursesRecyclerView = (RecyclerView) header.findViewById(R.id.recycler_view_popular_courses);

        // Set the direction of the recycler view
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        popularCoursesRecyclerView.setLayoutManager(layoutManager);

        courseAdapter = new CourseGridAdapter(getActivity(), Utilities.getCourses(getActivity(), catId));

        popularCoursesRecyclerView.setAdapter(courseAdapter);


        return view;
    }

    private void initSubCategories(String category) {


        Resources resource = getResources();

        subCategories = new LinkedList<>();


        switch (category) {
            case "Arts and Humanities":
                subCategories = Arrays.asList(resource.getStringArray(R.array.subcat_art));
                break;
            case "Computer Science":
                subCategories = Arrays.asList(resource.getStringArray(R.array.subcat_computer));
                break;
            case "Business":
                subCategories = Arrays.asList(resource.getStringArray(R.array.subcat_business));
                break;
            case "Social Sciences":
                subCategories = Arrays.asList(resource.getStringArray(R.array.subcat_social_sciences));
                break;
            case "Math and Logic":
                subCategories = Arrays.asList(resource.getStringArray(R.array.subcat_math));
                break;
            default:
                subCategories = Arrays.asList(resource.getStringArray(R.array.subcat_business));
                break;
        }


    }

/*
    private class SubCategoryAdapter extends ArrayAdapter<String>{

        private List<String> subCategories;
        private LayoutInflater inflater;

        public SubCategoryAdapter(int resource, List<String> subCategories){
            super(getActivity(),resource, subCategories);
            this.subCategories = subCategories;
            this.inflater = LayoutInflater.from(getActivity());
        }

        @Override
        public int getCount() {
            return subCategories.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }
    }

    */

}
