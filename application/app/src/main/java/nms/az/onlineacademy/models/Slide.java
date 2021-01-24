package nms.az.onlineacademy.models;

/**
 * Created by anar on 12/1/15.
 */
public class Slide {

    private String title;
    private String body;

    public  Slide(){

    }

    public Slide(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
