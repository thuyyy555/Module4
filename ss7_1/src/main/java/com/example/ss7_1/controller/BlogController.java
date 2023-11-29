package com.example.ss7_1.controller;

import com.example.ss7_1.model.Blog;
import com.example.ss7_1.model.Category;
import com.example.ss7_1.service.BlogService;
import com.example.ss7_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("list", blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/list_cate")
    public String showListCategory(Model model) {
        model.addAttribute("list", categoryService.findAll());
        return "blog/list_category";
    }
    
    @GetMapping("/list_blog/{id}")
    public String showListDetail(Model model, @PathVariable("id") int id) {
        model.addAttribute("list", blogService.findAllByCategory_CategoryId(id));
        return "blog/list";
    }

    @GetMapping("/list_paging")
    public String showListPaging(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.DESC, "date"));
        Page<Blog> blogs = blogService.findAllAndPaging(pageable);
        int totalPage = blogs.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            pageNumbers.add(i + 1);
        }

        model.addAttribute("blogs", blogs);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumbers", pageNumbers);

        return "blog/list_paging";
    }

    @GetMapping("/list_slice")
    public String showListPagingSlice(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.DESC, "date"));
        Slice<Blog> products = blogService.findAllSlice(pageable);
        model.addAttribute("products", products);
        model.addAttribute("pageSize", pageSize);

        return "blog/list_slice";
    }

    @GetMapping("/search")
    public String showSearch(Model model,
                             @RequestParam("blog_title") String name) {
        model.addAttribute("list", blogService.findAllByTitle(name));
        return "blog/list";
    }

    @GetMapping("/search_cate")
    public String showSearchCategory(Model model,
                                     @RequestParam("category_name") String name) {
        model.addAttribute("list", categoryService.findAllByCategoryName(name));
        return "blog/list_category";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @GetMapping("/create_cate")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "blog/create_cate";
    }

    @GetMapping("/update_cate")
    public String showUpdateCategory(@RequestParam("id") int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "blog/update";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog) {
        blog.setDate(LocalDate.now());
        blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
        blogService.create(blog);
        return "redirect:/blog/list";
    }

    @PostMapping("/create_cate")
    public String doCreateCategory(@ModelAttribute("category") Category category) {
        categoryService.create(category);
        return "redirect:/blog/list_cate";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        blog.setCategory(categoryService.findById(blog.getCategory().getCategoryId()));
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @PostMapping("/update_cate")
    public String doUpdate(@ModelAttribute("category") Category category) {
        categoryService.update(category);
        return "redirect:/blog/list_cate";
    }
    @GetMapping("/delete_cate/{id}")
    public String doDelete(@PathVariable("id") int id) {
        categoryService.deleteById(id);
        return "redirect:/blog/list_cate";
    }
}
