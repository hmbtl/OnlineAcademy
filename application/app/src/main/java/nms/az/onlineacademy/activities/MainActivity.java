package nms.az.onlineacademy.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.fragments.CategoryFragment;
import nms.az.onlineacademy.fragments.HomeFragment;
import nms.az.onlineacademy.models.Category;
import nms.az.onlineacademy.tools.JSONParser;
import nms.az.onlineacademy.tools.Utilities;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by anar on 8/13/15.
 */
public class MainActivity extends AppCompatActivity {

//    private ListView drawerList;
//    private List<String> categories;

//    private CategoryListAdapter adapter;

    private FragmentManager fragmentManager;

    private LinearLayout categoriesContainerExpanded;
    private TextView categoriesContainer;

    private boolean isCategoriesOpen = false;
    Toolbar toolbar;

    private boolean isAtHome = false;

    private TextView catArt, catBusiness, catComputerScience, catDataScience, catLifeScience, catMath;
    private TextView catPersonal, catPhysical, catSocial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            setTitle(getResources().getString(R.string.featured));
        }

        categoriesContainer = (TextView) findViewById(R.id.container_categories_lowered);
        categoriesContainerExpanded = (LinearLayout) findViewById(R.id.container_categories_expanded);

        categoriesContainer.setVisibility(View.VISIBLE);
        categoriesContainerExpanded.setVisibility(View.GONE);
        categoriesContainer.setOnClickListener(onClick);


        goHome();

        initCategories();



    }


    private void initCategories() {

        catArt = (TextView) findViewById(R.id.category_item_art);
        catBusiness = (TextView) findViewById(R.id.category_item_business);
        catComputerScience = (TextView) findViewById(R.id.category_item_computer_science);
        catDataScience = (TextView) findViewById(R.id.category_item_data_science);
        catLifeScience = (TextView) findViewById(R.id.category_item_life_scences);
        catMath = (TextView) findViewById(R.id.category_item_math_and_logic);
        catPersonal = (TextView) findViewById(R.id.category_item_personal);
        catPhysical = (TextView) findViewById(R.id.category_item_physical);
        catSocial = (TextView) findViewById(R.id.category_item_social);

        catArt.setOnClickListener(onClick);
        catBusiness.setOnClickListener(onClick);
        catComputerScience.setOnClickListener(onClick);
        catDataScience.setOnClickListener(onClick);
        catLifeScience.setOnClickListener(onClick);
        catMath.setOnClickListener(onClick);
        catPersonal.setOnClickListener(onClick);
        catPhysical.setOnClickListener(onClick);
        catSocial.setOnClickListener(onClick);
    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == categoriesContainer)
                toggleCategories();
            else if (view == catArt) {
                selectItem(catArt);
            } else if (view == catBusiness) {
                selectItem(catBusiness);
            } else if (view == catComputerScience) {
                selectItem(catComputerScience);
            } else if (view == catDataScience) {
                selectItem(catDataScience);
            } else if (view == catLifeScience) {
                selectItem(catLifeScience);
            } else if (view == catMath) {
                selectItem(catMath);
            } else if (view == catPersonal) {
                selectItem(catPersonal);
            } else if (view == catPhysical) {
                selectItem(catPhysical);
            } else if (view == catSocial) {
                selectItem(catSocial);
            }
        }
    };


    private void toggleCategories() {

        if (isCategoriesOpen) {
            isCategoriesOpen = false;
            Utilities.collapse(categoriesContainerExpanded);

        } else {
            isCategoriesOpen = true;
            Utilities.expand(categoriesContainerExpanded);
            categoriesContainerExpanded.setVisibility(View.VISIBLE);

        }

    }

    private void closeCategories() {
        isCategoriesOpen = false;
        Utilities.collapse(categoriesContainerExpanded);
    }

    private void openCategories() {
        isCategoriesOpen = true;
        Utilities.expand(categoriesContainerExpanded);
        categoriesContainerExpanded.setVisibility(View.VISIBLE);

    }

    private void selectItem(TextView cat) {
        // Create a new fragment and specify the planet to show based on position

        closeCategories();
        Fragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString("category", cat.getText().toString());
        args.putInt("catId", Utilities.getCatId(cat.getText().toString()));
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        setTitle(cat.getText().toString());
        isAtHome = false;

    }

    @Override
    public void setTitle(CharSequence title) {
        toolbar.setTitle(title);
    }

    @Override
    public void onBackPressed() {

        if (isCategoriesOpen)
            closeCategories();
        else {
            if (isAtHome) {

                super.onBackPressed();
            } else
                goHome();
        }


    }


    private void goHome() {
        fragmentManager = getSupportFragmentManager();

        Fragment fragment = new HomeFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        setTitle(R.string.featured);
        isAtHome = true;
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private class LoadCategories extends AsyncTask<String, String, String> {

        private ProgressDialog pDialog;
        private HashMap<String, String> params;
        private String url;


        public LoadCategories(HashMap<String, String> params) {
            this.params = params;
            this.url = "http://api.hmbtl.com/academy/v1/categories/";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Loading courses. Please wait.");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            JSONParser jsonParser = new JSONParser();
            String status = null;

            try {

                JSONObject json = jsonParser.sendPost(url, params);

                if (json == null) {
                    return null;
                }

                status = json.getString("status");

                if (status.equals("success")) {

                    JSONArray catsJSON = json.getJSONObject("data").getJSONArray("categories");

                    List<Category> cats = new LinkedList<>();

                    for (int i = 0; i < catsJSON.length(); i++) {
                        JSONObject catJSON = catsJSON.getJSONObject(i);

                        int id = catJSON.getInt("id");
                        String name = catJSON.getString("name");

                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

            return status;
        }

        @Override
        protected void onPostExecute(String status) {
            super.onPostExecute(status);

            pDialog.dismiss();


        }
    }

}
