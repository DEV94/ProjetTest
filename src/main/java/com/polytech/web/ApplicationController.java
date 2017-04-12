package com.polytech.web;

import com.polytech.business.SignInService;
import com.polytech.models.Post;
import com.polytech.business.PublicationService;
import com.polytech.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by dev on 3/15/17.
 */
@Controller
public class ApplicationController {


    @Autowired
    private PublicationService publicationService;

    @Autowired
    private SignInService signInService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String post(String content, Principal principal){
        System.out.println(principal.getName());
        System.out.println(content);
        publicationService.post(new Post(content));
        return "redirect:/feed";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signIn(String name, String password, Principal principal){
        System.out.println(name);
        signInService.signIn(new User(name, password, 1));
        return "index";
    }

    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public String sign(){
        return "newUser";
    }



    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String feed(Model model){
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts", posts);
        return "feed";
    }
}
