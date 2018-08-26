package action;

import Entity.PostTable;
import Entity.ReplyTable;
import Services.PostService;
import Services.ReplyService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddPostAction extends ActionSupport implements ModelDriven<PostTable> {
    PostTable post =new PostTable();
    PostService service = new PostService();
    @Override
    public String execute() throws Exception {
        service.savePost(post);
        return SUCCESS;
    }

    @Override
    public PostTable getModel() {
        return post;
    }
}
