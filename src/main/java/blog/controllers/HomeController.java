package blog.controllers;

import blog.models.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired /*Inject Postservice(services) in this controller. This service will take control of the data for the post*/
    private PostService postService;/*Postservice from it's side take his implementation("PostServiceImpl") to take the logic*/

    @RequestMapping("/")
    public String index(Model model) {
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);/*With this method we add data to the model*/


        List<Post> latest3Posts = latest5Posts.stream()/*With this method we add data to the model*/
                .limit(3)
                .collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        return "index";
    }
}
