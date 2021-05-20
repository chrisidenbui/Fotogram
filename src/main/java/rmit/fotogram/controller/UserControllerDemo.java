package rmit.fotogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rmit.fotogram.model.User;
import rmit.fotogram.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserControllerDemo {

    private final UserService userService;

    @Autowired
    public UserControllerDemo(UserService userService) {
        this.userService = userService;
    }
    

    @GetMapping(value = "/list")
    public String findAllUsers(Model model) {
        // get users from database
        List<User> users = userService.findAll();

        // add to Spring Model, can be used by Thymeleaf template
        model.addAttribute("listOfUsers", users);

        return "html/list-of-users";
    }

    // add mapping for GET "/users/id"
    @GetMapping("/{id}")
    public String findUserById() {
        return "";
    }
}
