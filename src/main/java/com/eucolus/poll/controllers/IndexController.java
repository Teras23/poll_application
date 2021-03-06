package com.eucolus.poll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model, Principal user) {
        return "index";
    }
}
