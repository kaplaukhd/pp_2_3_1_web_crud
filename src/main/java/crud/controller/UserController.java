package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
@RequestMapping("/users")
public class UserController {
    private final UserService<Long, User> userService;

    @Autowired
    public UserController(UserService<Long, User> userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "new_user";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String newUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update_user";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.POST})
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }


    @RequestMapping(value = "/{id}", method = {RequestMethod.POST})
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}
