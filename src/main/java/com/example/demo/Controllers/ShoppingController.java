package com.example.demo.Controllers;

import com.example.demo.Models.Product;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class ShoppingController {
    @Autowired
    private ProductService _productService;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String index(Map<String, Object> map){
        map.put("header", "shopping todos:");
        map.put("todos", _productService.getAll());
        return "index";
    }

    @ResponseBody
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Map<String, Object> add(@ModelAttribute("label") String label){
        Product res = _productService.add(label);
        return Map.of(
                "label", label,
                "id", res.getId(),
                "updTxt", res.isDoneStr()
        );
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Map<String, Boolean> switchIsDone(@PathVariable("id") int id){
        boolean state = _productService.switchIsDone(id);
        return Map.of("state", state);
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") int id){
        _productService.remove(id);
        return "";
    }
}
