package nms.az.onlineacademy.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import nms.az.onlineacademy.CourseContants;
import nms.az.onlineacademy.R;
import nms.az.onlineacademy.models.Chapter;
import nms.az.onlineacademy.models.Course;
import nms.az.onlineacademy.models.Slide;
import nms.az.onlineacademy.tools.JSONParser;
import nms.az.onlineacademy.tools.Utilities;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by anar on 7/22/15.
 */
public class LoginActivity extends AppCompatActivity {


    private ImageView appLogo, signInSectionIndicator, registerSectionIndicator;
    private EditText phoneNumber, pincode;
    private TextView forgotPassword, signinButton, registerButton;
    private CheckBox acceptTermsCheckBox;
    private Button loginButton;

    private boolean isActionLogin = true;

    private RelativeLayout loginContainer, generalContainer;

    private String regExCorrectPhone = "\\s*?(((50|51|55|70|77)([- ])?([2-9])))(\\d{2})([- ])?(\\d{2})([- ])?\\d{2}\\s*?$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize login screen views
        initLayoutViews();

        loginContainer.setVisibility(View.GONE);

        animateView(appLogo, loginContainer);

    }


    private void initLayoutViews() {

        generalContainer = (RelativeLayout) findViewById(R.id.login_general_container);

        // Application logo
        appLogo = (ImageView) findViewById(R.id.app_logo);

        // Login container to show after loading
        loginContainer = (RelativeLayout) findViewById(R.id.login_containers);

        phoneNumber = (EditText) findViewById(R.id.phone_number_edit_text);
        pincode = (EditText) findViewById(R.id.pincode_edit_text);

        signInSectionIndicator = (ImageView) findViewById(R.id.sign_in_section_indicator);
        registerSectionIndicator = (ImageView) findViewById(R.id.register_section_indicator);

        forgotPassword = (TextView) findViewById(R.id.login_forgot_button);
        acceptTermsCheckBox = (CheckBox) findViewById(R.id.accept_terms);

        loginButton = (Button) findViewById(R.id.login_signin_button);

        signinButton = (TextView) findViewById(R.id.sign_in_button);
        registerButton = (TextView) findViewById(R.id.register_button);

        signinButton.setOnClickListener(onClick);
        registerButton.setOnClickListener(onClick);
        loginButton.setOnClickListener(onClick);

    }


    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == signinButton)
                selectLoginSection();
            else if (view == registerButton)
                selectRegisterSection();
            else if (view == loginButton) {
                if (checkPhoneNumberFormat(phoneNumber)) {
                    if (isActionLogin) {
                        Log.e("todo", "login");
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Log.e("todo", "registration");
                    }

                }
            }
        }
    };


    private void selectLoginSection() {

        isActionLogin = true;

        pincode.setVisibility(View.VISIBLE);
        forgotPassword.setVisibility(View.VISIBLE);

        registerSectionIndicator.setVisibility(View.INVISIBLE);
        signInSectionIndicator.setVisibility(View.VISIBLE);

        acceptTermsCheckBox.setVisibility(View.GONE);

        registerButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        registerButton.setTypeface(null, Typeface.NORMAL);

        signinButton.setTextColor(getResources().getColor(R.color.colorAccent));
        signinButton.setTypeface(null, Typeface.BOLD);

        loginButton.setText(R.string.sign_in);
    }

    private void selectRegisterSection() {

        isActionLogin = false;

        pincode.setVisibility(View.GONE);
        forgotPassword.setVisibility(View.GONE);

        registerSectionIndicator.setVisibility(View.VISIBLE);
        signInSectionIndicator.setVisibility(View.INVISIBLE);


        registerButton.setTextColor(getResources().getColor(R.color.colorAccent));
        registerButton.setTypeface(null, Typeface.BOLD);

        signinButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        signinButton.setTypeface(null, Typeface.NORMAL);

        acceptTermsCheckBox.setVisibility(View.VISIBLE);

        loginButton.setText(R.string.register);
    }

    private void loadSplashScreen() {

    }

    private boolean checkPhoneNumberFormat(EditText phone) {


        if (phone.getText().toString().equals("")) {
            Utilities.showDialog(LoginActivity.this, R.string.empty_phone_edit_text, R.string.empty_phone_edit_text_message, R.string.ok);
            return false;
        } else if (!phone.getText().toString().matches(regExCorrectPhone)) {
            Utilities.showDialog(LoginActivity.this, R.string.wrong_number_format, R.string.wrong_number_format_message, R.string.ok);
            return false;
        }

        return true;
    }


    private void animateView(final View hidingPanel, final View showingPanel) {

        hidingPanel.setTranslationY(500);

        hidingPanel.animate()
                .translationY(0)
                .setDuration(2000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        hidingPanel.setTranslationY(0);

                        showingPanel.setAlpha(0.0f);
                        showingPanel.setVisibility(View.VISIBLE);

                        showingPanel.animate()
                                .alpha(1.0f)
                                .setDuration(400)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);


                                        showingPanel.setAlpha(1.0f);
                                        selectLoginSection();
                                       // new LoadCoursesAsync(showingPanel).execute();

                                    }
                                });
                    }
                });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private class TextWatcher implements android.text.TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

    private class LoadCoursesAsync extends AsyncTask<String, String, String> {
        private HashMap<String, String> params = new HashMap<>();

        private View panel;

        public LoadCoursesAsync(View panel) {
            this.panel = panel;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... prms) {
            JSONParser jsonParser = new JSONParser();
            String status = null;

            String url = "http://api.hmbtl.com/academy/v1/courses/";
            try {

                params.put("category_id", "1");

                Log.e("start", "started");

                JSONObject json = jsonParser.sendPost(url, params);
                Log.e("zor:", json.toString());

                if (json == null) {
                    return null;
                }

                status = json.getString("status");


                int index = 0;

                List<Course> courses = new LinkedList<>();
                if (status.equals("success")) {

                    JSONArray coursesJSON = json.getJSONObject("data").getJSONArray("courses");

                    for (int i = 0; i < coursesJSON.length(); i++) {
                        JSONObject courseJSON = coursesJSON.getJSONObject(i);

                        JSONArray crsJSON = courseJSON.getJSONArray("course");



                        for (int j = 0; j < crsJSON.length(); j++) {
                            JSONObject crs = crsJSON.getJSONObject(j);

                            String name = crs.getString("name");
                            JSONArray chapterJSON = crs.getJSONArray("chapter");
                            String image = crs.getString("image");

                            List<Chapter> chapters = new LinkedList<>();

                            chapters.clear();

                            for (int k = 0; k < chapterJSON.length(); k++) {

                                JSONObject chptr = chapterJSON.getJSONObject(k);

                                String chptrName = chptr.getString("name");

                                JSONArray slidesJSON = chptr.getJSONArray("slide");

                                List<Slide> slides = new LinkedList<>();
                                slides.clear();

                                for (int f = 0; f < slidesJSON.length(); f++) {

                                    JSONObject sld = slidesJSON.getJSONObject(f);

                                    String slideName = sld.getString("name");
                                    String sldBody = sld.getString("body");
                                    slides.add(new Slide(slideName, sldBody));
                                }

                                chapters.add(new Chapter(chptrName, slides));

                            }

                            courses.add(new Course(index, i + 1, name, chapters, 124124, image));
                            index++;

                        }

                    }

                }

                CourseContants.fillCourses(courses);


            } catch (Exception e) {
                e.printStackTrace();
            }

            return status;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            panel.setAlpha(1.0f);
            selectLoginSection();

        }
    }


}

