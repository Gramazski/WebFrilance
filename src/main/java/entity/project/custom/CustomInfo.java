package entity.project.custom;

import entity.jsp.project.info.user.SimpleUserClass;
import entity.project.order.OrderInfo;

import java.util.ArrayList;

/**
 * Created by gs on 11.12.2016.
 */
public class CustomInfo {
    private String timeAgo;
    private String body;
    private String name;
    private String price;
    private String type;
    private String condition;
    private SimpleUserClass author;
    private ArrayList<OrderInfo> frilancersOrders;

    public CustomInfo(String timeAgo, String body, String name, SimpleUserClass author, ArrayList<OrderInfo> frilancersOrders){
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

    public String getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public String getType() {
        return type;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
