package com.example.MVC_Proj_Crud.Controller;

import org.springframework.ui.Model;
import com.example.MVC_Proj_Crud.Model.Item;
import com.example.MVC_Proj_Crud.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.stereotype.Controller;
import java.util.Optional;



@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/items")
    public String listItems(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/list";
    }

    @GetMapping("/items/new")
    public String createItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "items/form";
    }

    @PostMapping("/items")
    public String saveItem(@ModelAttribute Item item) {
        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "items/form";
        } else {
            return "redirect:/items";
        }
    }

    @PostMapping("/items/update/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute Item item) {
        item.setId(id);
        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteById(id);
        return "redirect:/items";
    }
}
