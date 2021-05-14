package com.fotogram.Controller;

import org.springframework.web.bind.annotation.*;
import com.fotogram.Service.PostService;
import com.fotogram.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private PostService postService;

    @RequestMapping(path = "templates/HTML/Homepage.html", method = RequestMethod.GET)
    public List<Post> getAllPost () {
        return postService.getAllPost();
    }

}
