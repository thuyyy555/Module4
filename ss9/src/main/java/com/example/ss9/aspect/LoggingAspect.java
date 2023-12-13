package com.example.ss9.aspect;

import com.example.ss9.model.Book;
import com.example.ss9.service.BookService;
import com.example.ss9.service.BookServiceImpl;
import com.example.ss9.service.BorrowBService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Aspect
@Component
public class LoggingAspect {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowBService borrowBService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private int visitorCount = 0;

    @Before("execution(* com.example.ss9.controller.LibraryController.doBorrow(..))")
    public void logVisitorCountAfterBorrow() {
        visitorCount++;
        logger.info("Visitor count: " + visitorCount);
    }

    @AfterReturning(
            pointcut = "execution(* com.example.ss9.controller.LibraryController.doBorrow(..)) && args(id, idBorrow)",
            returning = "result",
            argNames = "id,idBorrow,result")
    public void afterBorrow(int id, int idBorrow, String result) {
        Book book = bookService.findById(id);
        System.out.println("Book co id la " + id + " da duoc muon");
        System.out.println("So luong sach hien tai cua sach co id " + id + ": " + book.getQuantity());
    }
    @AfterReturning(
            pointcut = "execution(* com.example.ss9.controller.LibraryController.doReturn(..)) && args(idBorrow)",
            returning = "result",
            argNames = "idBorrow,result")
    public void afterReturn(int idBorrow, String result) {
        int id = (borrowBService.findById(idBorrow)).getBook().getId();
        Book book = bookService.findById(id);
        System.out.println("Book co id la " + id + " da duoc tra");
        System.out.println("So luong sach hien tai cua sach co id " + id + ": " + book.getQuantity());
    }
}
