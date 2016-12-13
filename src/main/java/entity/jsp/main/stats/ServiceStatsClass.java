package entity.jsp.main.stats;

/**
 * Created by gs on 11.12.2016.
 */
public class ServiceStatsClass {
    private String open;
    private String complete;
    private String users;

    public ServiceStatsClass(String open, String complete, String users){
        this.open = open;
        this.complete = complete;
        this.users = users;
    }

    public String getComplete() {
        return complete;
    }

    public String getOpen() {
        return open;
    }

    public String getUsers() {
        return users;
    }
}
