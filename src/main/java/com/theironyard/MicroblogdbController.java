package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakefroeb on 10/7/16.
 */
@Controller
public class MicroblogdbController {

    @Autowired
    MessageRepository messages;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){

        List<Message> messageList = (ArrayList<Message>) messages.findAll();
        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("messages", messageList);
        return "home";
    }
    @RequestMapping(path="/login", method = RequestMethod.POST)
    public String login(HttpSession session, String loginName){
        session.setAttribute("userName", loginName);
        return "redirect:/";
    }
    @RequestMapping(path="/create-message", method = RequestMethod.POST)
    public String addMessage(String text){
        Message message = new Message(text);
        messages.save(message);
        return "redirect:/";
    }
    @RequestMapping(path="/delete-message", method = RequestMethod.POST)
    public String deleteMessage(int id){
        messages.delete(id);
        return "redirect:./";
    }






}
