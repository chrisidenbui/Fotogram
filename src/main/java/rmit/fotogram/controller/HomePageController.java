package rmit.fotogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rmit.fotogram.model.Post;
import rmit.fotogram.service.PostService;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    @Autowired
    private PostService postService;

    // add mapping for 'Home' button
    @GetMapping("/home")
    public String showHomePage() {
        return "html/homepage"; // --> homepage.html
    }

    // add mapping for 'Animals' button
    @GetMapping("/animals")
    public String showAnimals(Model model) {
        // TODO: update query find only animals
        // List<Post> posts = postService.findAllAnimal();
        List<Post> posts = postService.findAll();

        // add to Spring Model
        model.addAttribute("animalPosts", posts);
        return "html/animals";
    }

    // add mapping for 'Family' button
    @GetMapping("/family")
    public String showFamily(Model model) {
        // get all family posts from database
        List<Post> posts = postService.findAll();
        model.addAttribute("familyPosts", posts);
        return "html/family";
    }

    // add mapping for 'Natures' button
    @GetMapping("/natures")
    public String showNatures(Model model) {
        // get all family posts from database
        List<Post> posts = postService.findAll();
        model.addAttribute("naturesPosts", posts);
        return "html/natures";
    }

    // add mapping for 'Sky' button
     @GetMapping("/sky")
    public String showSky(Model model) {
        // get all family posts from database
        List<Post> posts = postService.findAll();
        model.addAttribute("skyPosts", posts);
        return "html/sky";
    }

    // add mapping for 'Love' button
    @GetMapping("/love")
    public String showLove(Model model) {
        // get all family posts from database
        List<Post> posts = postService.findAll();
        model.addAttribute("lovePosts", posts);
        return "html/love";
    }

    // add mapping for 'Images' button
    @GetMapping("/imagetab")
    public String showImageTab () {
        return "html/imagetab";
    }

    // add mapping for 'Collection' button
    @GetMapping("/collections")
    public String showCollections() {
        return "html/collections";
    }

    // add mapping for 'Explore' button
    @GetMapping("/explore")
    public String showExplore() {
        return "html/explore";
    }

    // add mapping for 'About Us' button
    @GetMapping("/about")
    public String showPhotos() {
        return "html/aboutus";
    }



}
