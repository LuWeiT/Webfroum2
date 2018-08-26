package action;

import Entity.PostTable;
import Entity.ReplyTable;
import Services.PostService;
import Services.ReplyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ShowDetailAction extends ActionSupport {
    long id;
    PostService service = new PostService();
    ReplyService replyService = new ReplyService();
    @Override
    public String execute() throws Exception {

        PostTable post = service.getPostById(getId());
        List<ReplyTable> list = replyService.getReplyByPostId(getId());
        ActionContext.getContext().put("post",post);
        ActionContext.getContext().put("replyList",list);
        return SUCCESS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
