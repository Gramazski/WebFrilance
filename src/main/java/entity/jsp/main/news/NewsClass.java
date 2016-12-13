package entity.jsp.main.news;

/**
 * Created by gs on 11.12.2016.
 */
public class NewsClass {
    private String title;
    private String body;
    private String timeAgo;
    private String totalTime;

    public NewsClass(String title, String body, String timeAgo, String totalTime){
        this.body = body;
        this.timeAgo = timeAgo;
        this.title = title;
        this.totalTime = totalTime;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public String getTotalTime() {
        return totalTime;
    }
}
