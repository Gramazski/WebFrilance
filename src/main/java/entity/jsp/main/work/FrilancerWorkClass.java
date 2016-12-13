package entity.jsp.main.work;

/**
 * Created by gs on 11.12.2016.
 */
public class FrilancerWorkClass {
    private String link;
    private String imgLink;
    private String altImgName;
    private String description;

    public FrilancerWorkClass(String link, String imgLink, String altImgName, String description){
        this.altImgName = altImgName;
        this.description = description;
        this.imgLink = imgLink;
        this.link = link;
    }

    public String getAltImgName() {
        return altImgName;
    }

    public String getDescription() {
        return description;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getLink() {
        return link;
    }
}
