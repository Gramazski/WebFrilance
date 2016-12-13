package entity.jsp.project.info.user;

/**
 * Created by gs on 11.12.2016.
 */
public class SimpleUserClass {
    private String name;
    private String yearsInService;

    public SimpleUserClass(String name, String yearsInService){
        this.name = name;
        this.yearsInService = yearsInService;
    }

    public String getName() {
        return name;
    }

    public String getYearsInService() {
        return yearsInService;
    }
}
