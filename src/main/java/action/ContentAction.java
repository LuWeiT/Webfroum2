package action;

import Entity.PostTable;
import Services.ContentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ContentAction extends ActionSupport {
    ContentService service = new ContentService();
    @Override
    public String execute() throws Exception {
        List<PostTable> list = service.getAllPost();

        ActionContext.getContext().put("list",list);
        return SUCCESS;
    }
}
