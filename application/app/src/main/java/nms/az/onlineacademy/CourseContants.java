package nms.az.onlineacademy;

import java.util.LinkedList;
import java.util.List;

import nms.az.onlineacademy.models.Course;

/**
 * Created by anar on 12/1/15.
 */
public class CourseContants {

    public static List<Course> courses = new LinkedList<>();


    public static void fillCourses(List<Course> courses) {
        CourseContants.courses.clear();
        CourseContants.courses = courses;
    }
}
