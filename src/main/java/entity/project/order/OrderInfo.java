package entity.project.order;

import entity.user.info.UserInfo;

/**
 * Created by gs on 11.12.2016.
 */
public class OrderInfo {
    private String timeAgo;
    private String customes;
    private UserInfo frilancer;
    private UserInfo customer;
    private String customName;

    public OrderInfo(String timeAgo, String customes, UserInfo frilancer){
        this.customes = customes;
        this.frilancer = frilancer;
        this.timeAgo = timeAgo;
    }

    public void setCustomer(UserInfo customer) {
        this.customer = customer;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomes() {
        return customes;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public UserInfo getFrilancer() {
        return frilancer;
    }

    public String getCustomName() {
        return customName;
    }

    public UserInfo getCustomer() {
        return customer;
    }
}
