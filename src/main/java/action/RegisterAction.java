package action;

import Entity.UserTable;
import Services.RegisterService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<UserTable> {
    RegisterService service = new RegisterService();
    UserTable user = new UserTable();
    @Override
    public String execute() throws Exception {
        try {
            service.register(user);
        }catch (Exception e){
            this.addActionError(e.getMessage());
            return "regiserFalse";
        }
        return SUCCESS;
    }

    @Override
    public UserTable getModel() {
        return user;
    }
}
