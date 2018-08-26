package action;

import Entity.ReplyTable;
import Services.ReplyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddReplyAction extends ActionSupport implements ModelDriven<ReplyTable> {
    ReplyTable reply =new ReplyTable();
    ReplyService service = new ReplyService();
    @Override
    public String execute() throws Exception {
        service.addReply(reply);
        ActionContext.getContext().put("postId",reply.getPostId());
        return SUCCESS;
    }

    @Override
    public ReplyTable getModel() {
        return reply;
    }
}
