package com.example.ss9.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int visitorCount = 0;

//    @Before("execution(* com.example.ss9.controller.LibraryController(..))")
//    public void logBorrowBook(int bookId, int userId) {
//        logger.info("Book with ID " + bookId + " is borrowed");
//    }

    @AfterReturning("execution(* com.example.ss9.controller.LibraryController.doBorrow(..))")
    public void logVisitorCountAfterBorrow() {
        visitorCount++;
        logger.info("Visitor count: " + visitorCount);
    }

//    @Before("execution(* com.example.ss9.controller.LibraryController.doReturn(..)) && args(bookId)")
//    public void logReturnBook(int bookId) {
//        logger.info("Book with ID " + bookId + " is returned");
//    }

}
