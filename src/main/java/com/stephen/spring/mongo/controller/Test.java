package com.stephen.spring.mongo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stephen.spring.mongo.model.User;
import com.stephen.spring.mongo.service.IUserService;

@Controller
@RequestMapping("/test")
public class Test {
    private final static Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/view", method=RequestMethod.GET) 
    public ModelAndView test(){
       ModelAndView mav = new ModelAndView();
       User user = this.userService.findUserByName("stephen");
       int count = this.userService.count();
       logger.debug("get count {}",count);
       logger.debug("get user name {}",user.getUserName());
       mav.setViewName("view");
       return mav;
     }
    
    @RequestMapping(value="/data", method=RequestMethod.GET)
    @ResponseBody
    public User getData(){
       ModelAndView mav = new ModelAndView();
       User user = this.userService.findUserByName("stephen");
       int count = this.userService.count();
       logger.debug("get count {}",count);
       logger.debug("get user name {}",user.getUserName());
       mav.setViewName("view");
       return user;
     }

}
