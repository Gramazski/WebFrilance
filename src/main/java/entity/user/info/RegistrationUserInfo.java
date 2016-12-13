package entity.user.info;

/**
 * Created by gs on 11.11.2016.
 */
public class RegistrationUserInfo extends AuthorizationUserInfo {
    private String clonePassword;
    private String name;
    private String surname;
    private String birthday;
    private String sex;
    private String role;

    public RegistrationUserInfo(String login, String password, String clonePassword, String name, String surname,
                                String birthday, String sex, String role, String email) {
        super(login, password, email);
        this.clonePassword = clonePassword;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
        this.role = role;
    }

    public String getClonePassword(){
        return clonePassword;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getSex() {
        return sex;
    }

    public String getSurname() {
        return surname;
    }
}
