package entity.user.info;

import entity.Mind.CustomerMind;
import entity.project.info.ProjectInfo;

import java.util.ArrayList;

/**
 * Created by gs on 09.11.2016.
 */
public class UserInfo{
    private String name;
    private String surname;
    private String imgLink;
    private String birthday;
    private String login;
    private String email;
    private String password;
    private String country;
    private String description;
    private String points;
    private String dateCreation;
    private String cost;
    private String costFrom;
    private String years;
    private String sex;
    private String role;
    private ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
    private ArrayList<CustomerMind> minds = new ArrayList<CustomerMind>();
    private ArrayList<String> messages = new ArrayList<String>();
    private ArrayList<String> orders = new ArrayList<String>();

    public UserInfo(){
        name = "No name";
        surname = "No surname";
        imgLink = "#";
        birthday = "-";
        login = "";
        email = "";
        password = "";
        country = "-";
        description = "-";
        points = "-";
        dateCreation = "-";
        cost = "-";
        costFrom = "-";
        years = "-";
        sex = "-";
        role = "-";
    }

    public void setMinds(ArrayList<CustomerMind> minds) {
        this.minds = minds;
    }

    public ArrayList<CustomerMind> getMinds() {
        return minds;
    }

    public ArrayList<ProjectInfo> getProjectInfos() {
        return projectInfos;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCost() {
        return cost;
    }

    public String getCountry() {
        return country;
    }

    public String getCostFrom() {
        return costFrom;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public ArrayList<String> getOrders() {
        return orders;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPoints() {
        return points;
    }

    public String getSurname() {
        return surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCostFrom(String costFrom) {
        this.costFrom = costFrom;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setProjectInfos(ArrayList<ProjectInfo> projectInfos) {
        this.projectInfos = projectInfos;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setOrders(ArrayList<String> orders) {
        this.orders = orders;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getRole() {
        return role;
    }

    public String getSex() {
        return sex;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
