package blog.controllers;

import blog.forms.CreatePostForm;
import blog.forms.LoginForm;
import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostsController {
    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;/*Adding this service we can use it's functionality in our posts*/

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){/*With @PathVariable we take "id" from uri and make it of tipe Long, for our method*/
        Post post = postService.findById(id);/*Here we take method findById from postService and use it*/
        if (post == null) {/*Some validations*/

            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);/*Add this particular post to the model*/
        return "posts/view";/*Create view to this path*/
    }

    @RequestMapping("posts")
    public String index(Model model){

        List<Post> allPosts = postService.findAll();

        model.addAttribute("findAll",
                allPosts);

        return "posts/index";
    }
    @RequestMapping("posts/create")/*GET method*/
    public String createPost(CreatePostForm createPostForm){
        return "posts/create";
    }

    @RequestMapping(value = "posts/create", method = RequestMethod.POST)
    public String addNewPost(@Valid CreatePostForm createPostForm,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            notifyService.addErrorMessage("Error");
            return "posts/create";
        }
        /*postService.create(new Post(16, createPostForm.getTitle(), createPostForm.getBody()));*/
        /*model.addAttribute(createPostForm.getTitle());
        model.addAttribute(createPostForm.getBody());*/
        postService.create(new Post(16, createPostForm.getTitle(), createPostForm.getBody()));
        notifyService.addInfoMessage("Post Created!!!");
        /*model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());*/
        return "posts/index";
    }
}
