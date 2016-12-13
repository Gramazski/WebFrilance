package entity.jsp.main.title;

/**
 * Created by gs on 10.12.2016.
 */
public class PageTitleClass {
    private String id;
    private String title;
    private String divClass;
    private String body;
    private String liClass;
    private String liName;

    public PageTitleClass(String id, String title, String divClass, String body, String liClass, String liName){
        this.id = id;
        this.title = title;
        this.divClass = divClass;
        this.body = body;
        this.liClass = liClass;
        this.liName = liName;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getDivClass() {
        return divClass;
    }

    public String getLiClass() {
        return liClass;
    }

    public String getLiName() {
        return liName;
    }

    public String getTitle() {
        return title;
    }
}
