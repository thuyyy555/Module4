package com.example.ltm.model.dao;

import com.example.ltm.model.bean.ConvertedFile;

import java.io.File;
import java.util.List;

public interface IFileDAO {
    List<ConvertedFile> displayListFile();
    List<ConvertedFile> search(String txtSearch);
    void delete(int id);
    File convertPDFtoDOCX(File pdfFile);
    void save(ConvertedFile convertedFile);
}
