package rmit.fotogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rmit.fotogram.model.Post;
import rmit.fotogram.service.PostService;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostControllerDemo {

    private final PostService postService;

    @Autowired
    public PostControllerDemo(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/list")
    public String findAllPost(Model model) {
        // get all posts from database
        List<Post> posts = postService.findAll();

        // add to Spring Model, can be used by Thymeleaf template
        model.addAttribute("listOfPosts", posts);

        return "html/list-of-posts";
    }
}
