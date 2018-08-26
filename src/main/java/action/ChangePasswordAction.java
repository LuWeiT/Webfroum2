package action;

import Services.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport  {
    String password;
    String username;
    String code;
    UserService service = new UserService();
    @Override
    public String execute() throws Exception {
        try{

        service.updateUserPasswordByUsername(username,password,code);
        }catch (Exception e){
            System.out.print(e);
            return "false";
        }
        return SUCCESS;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
