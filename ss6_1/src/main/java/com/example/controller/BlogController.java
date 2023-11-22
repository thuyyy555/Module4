package com.example.controller;
import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("/show")
    public String showList(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        blogService.create(blog);
        return "redirect:/blog/show";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        blogService.update(blog);
        return "redirect:/blog/show";
    }
    @GetMapping ("/delete")
    public String delete(@RequestParam("id") int id) {
        blogService.deleteById(id);
        return "redirect:/blog/show";
    }
}
