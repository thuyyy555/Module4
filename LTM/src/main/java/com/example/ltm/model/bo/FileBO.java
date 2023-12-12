package com.example.ltm.model.bo;

import com.example.ltm.model.bean.ConvertedFile;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileBO implements IFileBO {
    private final String SELECT = "SELECT * FROM file;";
    private final String SEARCH = "SELECT * FROM file WHERE fileName LIKE ?;";
    private final String DELETE = "delete from file where id = ?;";
    private final String INSERT = "INSERT INTO file (id, fileName, date) VALUES (?, ?, ?);";



    @Override
    public List<ConvertedFile> displayListFile() {
        List<ConvertedFile> list = new ArrayList<>();
        Connection con = BaseConnection.getConnection();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fileName = resultSet.getString("fileName");
                String date = resultSet.getString("date");
                list.add(new ConvertedFile(id, fileName, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<ConvertedFile> search(String txtSearch) {
        List<ConvertedFile> list = new ArrayList<>();
        Connection con = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + txtSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fileName = resultSet.getString("fileName");
                String date = resultSet.getString("date");
                list.add(new ConvertedFile(id, fileName, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(int id) {
        Connection con = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void save(ConvertedFile convertedFile) {
        Connection con = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT);
            preparedStatement.setInt(1, convertedFile.getId());
            preparedStatement.setString(2, convertedFile.getFileName());
            preparedStatement.setString(3, convertedFile.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File convertPDFtoDOCX(File pdfFile) {
        try {
            PDDocument document = PDDocument.load(pdfFile);
            PDFTextStripper stripper = new PDFTextStripper();
            String pdfText = stripper.getText(document);
            document.close();

            XWPFDocument doc = new XWPFDocument();

            // Thêm nội dung từ PDF vào file DOCX
            doc.createParagraph().createRun().setText(pdfText);

            File docxFile = new File("E:\\study");
            FileOutputStream fos = new FileOutputStream(docxFile);
            doc.write(fos);
            fos.close();

            return docxFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}