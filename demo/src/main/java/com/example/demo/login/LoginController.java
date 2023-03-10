package com.example.demo.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping
public class LoginController {

    @GetMapping(value = { "/"})
    public String hello() {
        return "WELCOME";
    }

    @GetMapping(value = { "/a"})
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");
        return model;
    }

    @GetMapping(value = { "/homePage"})
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("homePage");
        return model;
    }

    @GetMapping(value = "/loginPage")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out from JournalDEV successfully.");
        }

        model.setViewName("loginPage");
        return model;
    }

}