package action;

import Services.EmailService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SendEmailAction extends ActionSupport {
    private String email;
    private String username;
    EmailService service = new EmailService();
    @Override
    public String execute() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        System.out.print("username:"+username+" email:"+email);
        try {
            service.sendEmail(getEmail(), getUsername());
        }catch (Exception e){
            out.print(e.getMessage());
            return null;
        }
        out.print("send success");

        return null;


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
