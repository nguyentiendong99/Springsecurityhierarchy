package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private ProductService service;
    @RequestMapping("/")
    public String Show(Model model){
        List<Product> product = service.list();
        model.addAttribute("product",product);
        return "home";
    }
    @RequestMapping("/new")
    public String NewProduct(Map<String , Object> model){
        model.put("product" , new Product());
        return "new_product";
    }
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String Save(@ModelAttribute("product") Product product){
        service.save(product);
        return "redirect:/";
    }
    @RequestMapping( value = "/edit/{id}")
    public ModelAndView Edit(@PathVariable("id") Long id){
        ModelAndView model = new ModelAndView("edit_product");
        Product product = service.get(id);
        model.addObject("product", product);
        return model;
    }
    @RequestMapping("/delete/{id}")
    public String Delete(@PathVariable("id") long id){
        service.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/search")
    public ModelAndView Search(@RequestParam String keyword){
        ModelAndView model = new ModelAndView("search");
        List<Product> products = service.search(keyword);
        model.addObject("product", products);
        return model;
    }
}
