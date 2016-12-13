package entity.jsp.project.info;

import entity.project.order.OrderInfo;
import entity.jsp.project.info.user.SimpleUserClass;

import java.util.ArrayList;

/**
 * Created by gs on 11.12.2016.
 */
public class ProjectInfoClass {
    private String timeAgo;
    private String body;
    private String name;
    private SimpleUserClass author;
    private ArrayList<String> images;
    private ArrayList<OrderInfo> frilancersOrders;

    public ProjectInfoClass(String timeAgo, String body, String name, SimpleUserClass author, ArrayList<OrderInfo> frilancersOrders){
        this.author = author;
        this.body = body;
        this.frilancersOrders = frilancersOrders;
        this.timeAgo = timeAgo;
        this.name = name;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public ArrayList<OrderInfo> getFrilancersOrders() {
        return frilancersOrders;
    }

    public SimpleUserClass getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
