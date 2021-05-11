package com.fotogram.hibernate.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(path = "templates/HTML/Homepage.html" ,method = RequestMethod.GET)
    public void displayImages(){

    }
}
