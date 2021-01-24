package nms.az.onlineacademy.models;

import java.util.List;

/**
 * Created by anar on 10/11/15.
 */
public class Chapter {

    private String content;
    private int image;
    private String title;
    private List<Slide> slides;

    public Chapter(String title, String content, int image){
        this.title = title;
        this.content = content;
        this.image = image;
    }


    public Chapter(String title, List<Slide> slides){
        this.title = title;
        this.slides = slides;

    }

    public List<Slide> getSlides() {
        return slides;
    }

    public void setSlides(List<Slide> slides) {
        this.slides = slides;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
