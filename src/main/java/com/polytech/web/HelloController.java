package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by dev on 3/15/17.
 */
@Controller
public class HelloController {


    @Autowired
    private PublicationService publicationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "forward:index.html";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home(){
        return "Hello";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String feed(Model model){
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts", posts);
        return "feeds";
    }

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public void post(String content){
        System.out.println(content);
        publicationService.post(new Post(content));
    }
}