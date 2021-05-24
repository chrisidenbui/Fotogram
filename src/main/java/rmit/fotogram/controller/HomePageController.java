package rmit.fotogram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomePageController {

    // add mapping for 'Home' button
    @GetMapping("/home")
    public String showHomePage() {
        return "html/homepage"; // --> homepage.html
    }

    // add mapping for 'Images' button
    @GetMapping("/imagetab")
    public String showImageTab () {
        return "html/imagetab";
    }

    // add mapping for 'Images' button
    @GetMapping("/animals")
    public String showAnimals () {
        return "html/animals";
    }

    // add mapping for 'Photos' button
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
