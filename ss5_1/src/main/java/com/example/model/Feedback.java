package com.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFeedback;
    private int point;
    private String comment;
    private int count;
    private String author;
    private LocalDate today;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idPicture", referencedColumnName = "idPicture")
    private Picture picture;

    public Feedback() {
    }

    public Feedback(int idFeedback, int point, String comment, int count, String author, LocalDate today, Picture picture) {
        this.idFeedback = idFeedback;
        this.point = point;
        this.comment = comment;
        this.count = count;
        this.author = author;
        this.today = today;
        this.picture = picture;
    }

    public Feedback(LocalDate today) {
        this.today=today;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Feedback(int idFeedback, int point, String comment, String author, LocalDate today, Picture picture) {
        this.idFeedback = idFeedback;
        this.point = point;
        this.comment = comment;
        this.author = author;
        this.today = today;
        this.picture = picture;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

}
