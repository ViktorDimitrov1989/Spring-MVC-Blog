package blog.controllers;
import java.util.*;
import java.util.List;

import blog.forms.RegistrationForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.hibernate.mapping.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("users")
    public String index(Model model){

        List<User> allUsers = userService.findAll();

        model.addAttribute("findAll",
                allUsers);
        if (allUsers.isEmpty()){
            return "redirect:/";
        }
        /*Here we take method findAll() from userService and use it*/

        return "users/index";/*Create view to this path*/

    }

    @RequestMapping("users/register")
    public String register(){
        return "users/register";
    }
}
