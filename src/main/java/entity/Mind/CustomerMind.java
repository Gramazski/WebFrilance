package entity.Mind;

import entity.user.info.UserInfo;

/**
 * Created by gs on 11.12.2016.
 */
public class CustomerMind {
    private String author;
    private UserInfo frilancer;
    private String body;
    private String mark;
    private String time;
    private String title;

    public CustomerMind(String author, String body, String mark, String time, String title){
        this.author = author;
        this.body = body;
        this.mark = mark;
        this.time = time;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public String getMark() {
        return mark;
    }

    public UserInfo getFrilancer() {
        return frilancer;
    }

    public String getTime() {
        return time;
    }
}
