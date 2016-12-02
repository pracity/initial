package com.pracity.service.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Hello {
    @RequestMapping("/greeting1")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World123") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
