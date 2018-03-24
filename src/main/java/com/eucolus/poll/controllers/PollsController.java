package com.eucolus.poll.controllers;

import com.eucolus.poll.entities.Poll;
import com.eucolus.poll.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class PollsController {
    @Autowired
    private PollRepository pollRepository;

    @GetMapping("/polls")
    public String polls(Model model, Principal user) {
        if(user != null)
            model.addAttribute("user", user.getName());
        else
            model.addAttribute("user", null);

        model.addAttribute("polls", pollRepository.findAll());
        return "polls";
    }

    @GetMapping("/create_poll")
    public String poll(Model model, Principal user) {
        if(user != null)
            model.addAttribute("user", user.getName());
        else
            model.addAttribute("user", null);

        Poll newPoll = new Poll();
        newPoll.setTitle("Title");
        pollRepository.save(newPoll);

        model.addAttribute("poll", newPoll);
        return "questions";
    }

    @GetMapping("/polls/{pollId}")
    public String poll(@PathVariable(value="pollId") Integer pollId, Model model, Principal user) {
        if(user != null)
            model.addAttribute("user", user.getName());
        else
            model.addAttribute("user", null);

        model.addAttribute("poll", pollRepository.findOne(pollId));
        return "questions";
    }
}