package com.teamh.hiserver.global.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/auction")
    public String rendAuction(){
        return "auction";
    }

    @RequestMapping("/signup")
    public String rendSignup(){
        return "signup";
    }
}
