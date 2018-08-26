package action;

import Entity.UserTable;
import Services.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<UserTable> {
    UserTable user=new UserTable();
    LoginService loginService = new LoginService();
    @Override
    public String execute() throws Exception {
        UserTable u =new UserTable();
        try{
         u=loginService.login(user);
        }catch (Exception e){
            this.addActionError(e.getMessage());
            return "false";
        }

        ActionContext.getContext().getSession().put("user",u);
        return "success";
    }

    @Override
    public UserTable getModel() {
        return user;
    }
}
