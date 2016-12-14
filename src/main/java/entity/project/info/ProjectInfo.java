package entity.project.info;

import entity.Mind.CustomerMind;
import entity.project.custom.CustomInfo;
import entity.user.info.UserInfo;

import java.util.ArrayList;

/**
 * Created by gs on 11.12.2016.
 */
public class ProjectInfo {
    private UserInfo frilancer;
    private ArrayList<CustomerMind> minds;
    private CustomInfo customInfo;
    private String imgLink;
    private String description;
    private String title;

    public ProjectInfo(UserInfo frilancer, CustomInfo customInfo, String imgLink, String title){
        this.customInfo = customInfo;
        this.frilancer = frilancer;
        this.imgLink = imgLink;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<CustomerMind> getMinds() {
        return minds;
    }

    public CustomInfo getCustomInfo() {
        return customInfo;
    }

    public UserInfo getFrilancer() {
        return frilancer;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setMinds(ArrayList<CustomerMind> minds) {
        this.minds = minds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFrilancer(UserInfo frilancer) {
        this.frilancer = frilancer;
    }
}
