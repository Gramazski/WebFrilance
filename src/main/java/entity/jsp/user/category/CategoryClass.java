package entity.jsp.user.category;

/**
 * Created by gs on 11.12.2016.
 */
public class CategoryClass {
    private String link;//redirect
    private String visitingCount;
    private String name;

    public CategoryClass(String link, String visitingCount, String name){
        this.link = link;
        this.visitingCount = visitingCount;
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getVisitingCount() {
        return visitingCount;
    }
}
