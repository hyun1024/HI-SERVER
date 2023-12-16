package com.teamh.hiserver.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/auction")
    public String RendAuction(){
        return "auction";
    }

    @RequestMapping("/signup")
    public String RendSignup(){
        return "signup";
    }
}
