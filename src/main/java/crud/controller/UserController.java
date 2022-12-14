package crud.controller;


import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService<Long, User> userService;

    @Autowired
    public UserController(UserService<Long, User> userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String indexPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/new_user")
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "new_user";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }


    @PatchMapping("")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:users";
    }
}
