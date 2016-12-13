package entity.jsp.main.forum;

/**
 * Created by gs on 11.12.2016.
 */
public class ForumThemeClass {
    private String link;
    private String title;
    private String timeAgo;
    private String messageCount;
    private String imgLink;

    public ForumThemeClass(String link, String title, String timeAgo, String messageCount, String imgLink){
        this.link = link;
        this.messageCount = messageCount;
        this.timeAgo = timeAgo;
        this.title = title;
        this.imgLink = imgLink;
    }

    public String getLink() {
        return link;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public String getTitle() {
        return title;
    }

    public String getMessageCount() {
        return messageCount;
    }

    public String getImgLink() {
        return imgLink;
    }
}
