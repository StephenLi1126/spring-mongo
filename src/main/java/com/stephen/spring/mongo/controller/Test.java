package com.stephen.spring.mongo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getMovie(@PathVariable String name, ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("query", "");
        model.addAttribute("submit", "");
        return "hello";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(@RequestParam("name") String name, ModelMap model) {
        model.addAttribute("name", "");
        model.addAttribute("query", name);
        model.addAttribute("submit", "");
        return "hello";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public String submit(@RequestParam("name") String name, ModelMap model) {
        model.addAttribute("name", "");
        model.addAttribute("query", "");
        model.addAttribute("submit", name);
        return "hello";
    }
    @RequestMapping(path = "/list", method = RequestMethod.GET)  
    public ModelAndView showZooList(){
    	ModelAndView modelAndView  = new ModelAndView();
    	
    	modelAndView.addObject("test", "hello");
    	modelAndView.setViewName("view");
    	return modelAndView;
    } 

}
