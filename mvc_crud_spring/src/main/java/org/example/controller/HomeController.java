package org.example.controller;

import org.example.dao.empDao;
import org.example.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @Autowired
    private empDao empDao;

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String home(Model m){
        m.addAttribute("allEmp",empDao.get());
        m.addAttribute("emp",new Employe());
        return "home";
    }

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ModelAndView saveEmp(@ModelAttribute("emp") Employe emp ){
        if(empDao.save(emp))
            return new ModelAndView("redirect:" + "/");
        else
            return new ModelAndView("redirect:" + "/");
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id, RedirectAttributes re){
        Employe emp = empDao.first(id);

        if(empDao.delete(emp))
        re.addAttribute("fire","true");
        re.addAttribute("icon","success");
        re.addAttribute("title","Record Deleted Sucessfuly !");
        return "redirect:/";
    }

    @RequestMapping(value = "/edit" , method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView edit(@ModelAttribute("emp2") Employe emp){
        if(empDao.update(emp))
            return new ModelAndView("redirect:" + "/");
        else
            return new ModelAndView("redirect:" + "/");
    }

    @RequestMapping(value = "/edit/{id}" , method = RequestMethod.GET)
    public String userEdit(@PathVariable("id") int id , Model m){
        m.addAttribute("emp2",new Employe());
        m.addAttribute("row",empDao.first(id));
        return "../modal/edit";
    }

//    @RequestMapping(value = "/hey/{id}" , method = RequestMethod.GET)
//    @ResponseBody
//    public String hey(@PathVariable("id") int id){
//        return empDao.first(id).toString();
////        return "index";
//    }

//    @RequestMapping(value = "/page/{id}/name/{name}" , method = RequestMethod.GET)
//    public ModelAndView page(@PathVariable int id,@PathVariable String name){
//        ModelAndView index = new ModelAndView("index");
//        index.addObject("name",name);
//        index.addObject("id",id);
//        return index;
//    }


}
