package com.example.ss9.controller;

import com.example.ss9.model.Book;
import com.example.ss9.model.BorrowBook;
import com.example.ss9.service.BookService;
import com.example.ss9.service.BorrowBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class LibraryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowBService borrowBService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "view";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model,
                             @PathVariable("id") int id) {
        Random random = new Random();
        int idBorrow = random.nextInt(90000) + 10000;
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("idBorrow", idBorrow);
        return "detail";
    }
    @PostMapping("/borrow")
    public String doBorrow(@ModelAttribute("id") int id, @ModelAttribute("idBorrow") int idBorrow) {
        Book book = bookService.findById(id);
        book.setQuantity(book.getQuantity()-1);
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setBorrowId(idBorrow);
        borrowBook.setBook(book);
        borrowBService.create(borrowBook);
        return "redirect:/book/list";
    }
    @GetMapping("/return")
    public String doReturn(@RequestParam("idBorrow") int idBorrow) {
        if((borrowBService.findById(idBorrow))!=null){
            int idBook = (borrowBService.findById(idBorrow)).getBook().getId();
            Book book = bookService.findById(idBook);
            book.setQuantity(book.getQuantity()+1);
            bookService.update(book);
            return "redirect:/book/list";
        }else {
            return "error";
        }
    }
}
