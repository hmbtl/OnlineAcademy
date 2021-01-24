package nms.az.onlineacademy.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

/**
 * Created by anar on 7/29/15.
 */
public class Course implements Parcelable {

    private int id, numberOfStudents;
    private String name, imageURL;
    private List<Chapter> chapters;
    private int imageResource;

    private int catId;

    public Course() {
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public Course(int id, int catId, String name,   int numberOfStudents, String imgURL) {
        this.id = id;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.imageURL = imgURL;
    }


    public Course(int id, int catId, String name, List<Chapter> chapters, int numberOfStudents, String imageURL) {
        this.id = id;
        this.catId = catId;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.imageURL = imageURL;
        this.chapters = chapters;
    }


    public Course(int id, int catId, String name, List<Chapter> chapters, int numberOfStudents, int imageResource) {
        this.id = id;
        this.catId = catId;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.imageResource = imageResource;
        this.chapters = chapters;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getId() {
        return id;
    }


    public String getImageURL() {
        return imageURL;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public static Creator getCREATOR() {
        return CREATOR;
    }


    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }


    public Course(Parcel in) {



        this.id = in.readInt();
        this.catId = in.readInt();
        this.name = in.readString();
        this.numberOfStudents = in.readInt();
        this.imageURL = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v("COURSE", "writeToParcel..." + flags);
        dest.writeInt(id);
        dest.writeInt(catId);
        dest.writeString(name);
        dest.writeInt(numberOfStudents);
        dest.writeString(imageURL);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        public Course[] newArray(int size) {
            return new Course[size];
        }
    };


    @Override
    public String toString() {
        return name;
    }
}
