package entity.jsp.project.stats;

/**
 * Created by gs on 11.12.2016.
 */
public class ProjectStatsClass {
    private String viewCount;
    private String orderCount;

    public ProjectStatsClass(String viewCount, String orderCount){
        this.orderCount = orderCount;
        this.viewCount = viewCount;
    }

    public String getOrderCount() {
        return orderCount;
    }

    public String getViewCount() {
        return viewCount;
    }
}
