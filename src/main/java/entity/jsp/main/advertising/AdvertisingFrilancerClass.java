package entity.jsp.main.advertising;

/**
 * Created by gs on 11.12.2016.
 */
public class AdvertisingFrilancerClass {
    private String imgLink;
    private String frilancerLink;
    private String frilancerData;
    private String description;

    public AdvertisingFrilancerClass(String imgLink, String frilancerLink, String frilancerData, String description){
        this.description = description;
        this.frilancerData = frilancerData;
        this.frilancerLink = frilancerLink;
        this.imgLink = imgLink;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getDescription() {
        return description;
    }

    public String getFrilancerData() {
        return frilancerData;
    }

    public String getFrilancerLink() {
        return frilancerLink;
    }
}
