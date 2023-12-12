package com.example.ltm.model.bean;

import java.time.LocalDate;
import java.util.Date;

public class ConvertedFile {
    private int id;
    private String fileName;
    private String date;
//    private String filePath;

    public ConvertedFile() {
    }

    public ConvertedFile(int id, String fileName, String date) {
        this.id = id;
        this.fileName = fileName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
