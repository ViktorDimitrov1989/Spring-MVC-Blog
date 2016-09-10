package blog.controllers;

import blog.forms.LoginForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired /*Include this service -> dependency injection "Dependencies are being injected into your class"*/
    private UserService userService;

    @Autowired /*Include this service*/
    private NotificationService notifyService;

    @RequestMapping("/users/login")/*Path*/
    public String login(LoginForm loginForm) {
        return "users/login";
    }
    /*In the method above we pass data from it to LoginForm in "forms" */
    /*GET*/

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult)
        /*validate the form and result from validation will be injected with Bindingresult*/ {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }
        /*If passed data is valid, we enter this method!!!*/
        if (!userService.authenticate(
                loginForm.getUsername(), loginForm.getPassword())) {
            notifyService.addErrorMessage("Invalid login!");
            return "users/login";
        }

        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}