package com.example.ltm.model.bo;

import com.example.ltm.model.bean.ConvertedFile;
import com.example.ltm.model.dao.FileDAO;
import com.example.ltm.model.dao.IFileDAO;

import java.io.File;
import java.util.List;

public class FileBO implements IFileBO {
    IFileDAO iFile = new FileDAO();
    @Override
    public List<ConvertedFile> displayListFile() {
        return iFile.displayListFile();
    }

    @Override
    public List<ConvertedFile> search(String txtSearch) {
        return iFile.search(txtSearch);
    }

    @Override
    public void delete(int id) {
        iFile.delete(id);
    }

    @Override
    public File convertPDFtoDOCX(File pdfFile) {
        return iFile.convertPDFtoDOCX(pdfFile);
    }

    @Override
    public void save(ConvertedFile convertedFile) {
        iFile.save(convertedFile);
    }
}
