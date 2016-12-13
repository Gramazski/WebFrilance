package entity.jsp.forum.theme;

/**
 * Created by gs on 11.12.2016.
 */
public class ForumThemeClass {
    private String timeAgo;
    private String title;
    private String imgLink;
    private String link;
    private String messageCount;
    //private ArrayList<ForumMessage> messages;

    public ForumThemeClass(String timeAgo, String title, String imgLink, String link){
        this.timeAgo = timeAgo;
        this.imgLink = imgLink;
        this.link = link;
        //this.messages = messages;
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public String getMessageCount() {
        return "4";
    }
}
