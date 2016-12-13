package entity.jsp.main.frilancer;

/**
 * Created by gs on 11.12.2016.
 */
public class FrilancerTopClass {
    private String name;
    private String points;
    private String link;

    public FrilancerTopClass(String link, String name, String points){
        this.name = name;
        this.points = points;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getPoints() {
        return points;
    }

    public String getLink() {
        return link;
    }
}
