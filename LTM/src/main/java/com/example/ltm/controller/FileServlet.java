package com.example.ltm.controller;

import com.example.ltm.model.bean.ConvertedFile;
import com.example.ltm.model.bo.FileBO;
import com.example.ltm.model.bo.IFileBO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet(name = "fileServlet", value = "")
@MultipartConfig
public class FileServlet extends HttpServlet {
    private IFileBO iFile = new FileBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                create(request, response);
                break;
            case "showFormConvert":
                showFormConvert(request, response);
                break;
            case "display":
//                displayFile(request, response);
                break;
            default:
                displayFile(request, response);
        }
    }

    private void displayFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ConvertedFile> list = this.iFile.displayListFile();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showFormConvert(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("convert.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                delete(req, resp);
                break;
            case "convert":
                convert(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
            default:
                displayFile(req, resp);
        }
    }

    private void convert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/msword");
        String fileName = request.getParameter("fileName");
        Part filePart = request.getPart("filePath");
        String date = request.getParameter("date");
        int id = Integer.parseInt(request.getParameter("idFile"));
        ConvertedFile convertedFile = new ConvertedFile(id, fileName, date);
        iFile.save(convertedFile);

        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream pdfFile = filePart.getInputStream();
                 PDDocument document = PDDocument.load(pdfFile)) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(document);

                XWPFDocument doc = new XWPFDocument();
                XWPFParagraph paragraph = doc.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setText(text);

                response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".docx");
                doc.write(response.getOutputStream());

            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("Không có file được tải lên.");
        }
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iFile.delete(id);
        List<ConvertedFile> list = iFile.displayListFile();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void search(HttpServletRequest request, HttpServletResponse response) {
        String txtSearch = request.getParameter("txtSearch");
        List<ConvertedFile> list = iFile.search(txtSearch);
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
