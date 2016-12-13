package entity.user.info;

/**
 * Created by gs on 09.11.2016.
 */
//Rename class!
public class AuthorizationUserInfo {
    private String login;
    private String password;
    private String email;
    private int id;

    public AuthorizationUserInfo(String login, String password, String email){
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

}
