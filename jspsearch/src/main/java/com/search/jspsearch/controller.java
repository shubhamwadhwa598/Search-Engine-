package com.search.jspsearch;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class controller {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHome(){

        return "search";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String hitquery(){
        return "search";
    }


    @RequestMapping(path = "process_search" , method = RequestMethod.POST)
    public String processSearch(HttpServletRequest request, Model model){

        ArrayList<String> li = CsvReader.hitquery(request.getParameter("query"));

        model.addAttribute("str",request.getParameter("query"));
        model.addAttribute("name",request.getParameter("name"));

        if(li.isEmpty()){
            model.addAttribute("list","oops no result found");
            //model.addAttribute("str",request.getParameter("query"));
        }
        else {
            model.addAttribute("list", li);
        }


        return "success";


    }
}
