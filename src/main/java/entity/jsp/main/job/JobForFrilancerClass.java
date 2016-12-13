package entity.jsp.main.job;

/**
 * Created by gs on 11.12.2016.
 */
public class JobForFrilancerClass {
    private String link;
    private String title;
    private String cost;
    private String orderCount;
    private String description;
    private String jobTag;
    private String jobTagLink;
    private String totalTime;
    private String timeAgo;
    private String jobType;

    public JobForFrilancerClass(String link, String title, String cost, String orderCount, String description, String jobTag,
                                String jobTagLink, String totalTime, String timeAgo, String jobType){
        this.cost = cost;
        this.description = description;
        this.jobTag = jobTag;
        this.jobTagLink = jobTagLink;
        this.link = link;
        this.jobType = jobType;
        this.orderCount = orderCount;
        this.timeAgo = timeAgo;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public String getCost() {
        return cost;
    }

    public String getJobTag() {
        return jobTag;
    }

    public String getJobTagLink() {
        return jobTagLink;
    }

    public String getJobType() {
        return jobType;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public String getTimeAgo() {
        return timeAgo;
    }
}
