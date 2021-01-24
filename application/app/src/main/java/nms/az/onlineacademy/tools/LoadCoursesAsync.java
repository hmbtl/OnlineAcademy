package nms.az.onlineacademy.tools;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import nms.az.onlineacademy.CourseContants;
import nms.az.onlineacademy.models.Chapter;
import nms.az.onlineacademy.models.Course;
import nms.az.onlineacademy.models.Slide;

/**
 * Created by anar on 12/1/15.
 */
public class LoadCoursesAsync extends AsyncTask<String, String, String> {
    private HashMap<String, String> params;

    public LoadCoursesAsync() {
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... prms) {
        JSONParser jsonParser = new JSONParser();
        String status = null;

        String url = "http://api.bibro.ml/academy/v1/courses";
        try {

            JSONObject json = jsonParser.sendGet(url, params);

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

                        List<Chapter> chapters = new LinkedList<>();

                        index++;
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

                        courses.add(new Course(index, i, name, chapters, 124124, ""));

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
    }
}
