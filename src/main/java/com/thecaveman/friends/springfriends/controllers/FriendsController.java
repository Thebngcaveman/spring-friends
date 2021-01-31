package com.thecaveman.friends.springfriends.controllers;

import com.thecaveman.friends.springfriends.model.Friend;
import com.thecaveman.friends.springfriends.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FriendsController {

    @Autowired//autowired from service
    private FriendService friendService;

    @GetMapping("/") //localhost:8080
    public String home(Model model){
        model.addAttribute("ListOfFriends", friendService.getAllFriends());
        return "home";
    }

    @GetMapping("/showNewFriendForm")
    public String showNewFriendForm(Model model){
        Friend friend = new Friend();
        model.addAttribute("friend", friend); //(key,value)
        return "new_friend";
    }

    @PostMapping("/saveFriend")
    public String saveFriend(@ModelAttribute("friend") Friend friend){
        friendService.saveFriends(friend);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Friend friend = friendService.getFriendsById(id);
        model.addAttribute("friend", friend);
        return "update_friend";
    }

    @GetMapping("/deleteFriend/{id}")
    public String deleteFriend(@PathVariable (value = "id")long id){
        this.friendService.deleteFriendsById(id);
        return "redirect:/";
    }
}
