package entity.jsp.forum.message;

import entity.user.info.UserInfo;

/**
 * Created by gs on 11.12.2016.
 */
public class ForumMessage {
    private String timeAgo;
    private String title;
    private String imgLink;
    private UserInfo author;

    public ForumMessage(String timeAgo, String title, String imgLink, UserInfo author){
        this.timeAgo = timeAgo;
        this.author = author;
        this.imgLink = imgLink;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public UserInfo getAuthor() {
        return author;
    }
}
