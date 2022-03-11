package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "Hello";
    }

    @RequestMapping(value = "/hey" , method = RequestMethod.GET)
    @ResponseBody
    public String hey(){
        return "Fuck World";
    }

    @RequestMapping(value = "/page" , method = RequestMethod.GET)
    public ModelAndView page(){
        ModelAndView index = new ModelAndView("index");
        index.addObject("name","Israfil");

        return index;
    }
}
