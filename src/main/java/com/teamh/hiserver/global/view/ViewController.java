package com.teamh.hiserver.global.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/auction")
    public String rendAuction(){
        return "auction";
    }

    @RequestMapping("/signup")
    public String rendSignup(){
        return "signup";
    }

    @RequestMapping("/home")
    public String rendHome(){
        return "home";
    }
    @RequestMapping("/login")
    public String rendLogin() {
    	return "index";
    }
    @RequestMapping("/item")
    public String rendItem() {
    	return "item";
    }
    @RequestMapping("/shop")
    public String rendShop() {
    	return "shop";
    }
    @RequestMapping("/mypage")
    public String rendMypage() {
    	return "mypage";
    }
    @RequestMapping("/ranking")
    public String rendRanking() {
    	return "ranking";
    }
    @RequestMapping("/notice")
    public String rendNotice() {
    	return "notice";
    }
}
