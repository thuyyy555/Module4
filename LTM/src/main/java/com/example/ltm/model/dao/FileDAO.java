package com.example.ltm.model.dao;

import com.example.ltm.model.bean.ConvertedFile;
import com.example.ltm.model.bo.FileBO;
import com.example.ltm.model.bo.IFileBO;

import java.io.File;
import java.util.List;

public class FileDAO implements IFileDAO{
    IFileBO iFileBO = new FileBO();
    @Override
    public List<ConvertedFile> displayListFile() {
        return iFileBO.displayListFile();
    }

    @Override
    public List<ConvertedFile> search(String txtSearch) {
        return iFileBO.search(txtSearch);
    }

    @Override
    public void delete(int id) {
        iFileBO.delete(id);
    }

    @Override
    public File convertPDFtoDOCX(File pdfFile) {
        return iFileBO.convertPDFtoDOCX(pdfFile);
    }

    @Override
    public void save(ConvertedFile convertedFile) {
        iFileBO.save(convertedFile);
    }
}
