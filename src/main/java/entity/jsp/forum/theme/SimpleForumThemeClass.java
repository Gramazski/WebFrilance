package entity.jsp.forum.theme;

import java.util.ArrayList;

/**
 * Created by gs on 11.12.2016.
 */
public class SimpleForumThemeClass {
    private String name;
    private String link;
    private ArrayList<SimpleForumThemeClass> subThemes;
    private String messageCount;

    public SimpleForumThemeClass(String link, String name){
        this.link = link;
        this.name = name;
        subThemes = new ArrayList<SimpleForumThemeClass>();
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getMessageCount() {
        return "4";
    }

    public ArrayList<SimpleForumThemeClass> getSubThemes() {
        return subThemes;
    }

    public void addSubTheme(SimpleForumThemeClass subTheme){
        subThemes.add(subTheme);
    }
}
