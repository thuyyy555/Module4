package com.example.ltmserver.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6543);
            System.out.println("Server is running...");

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("Client connected!");

                BufferedInputStream inFromClient = new BufferedInputStream(connectionSocket.getInputStream());

                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int bytesRead;
                while ((bytesRead = inFromClient.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, bytesRead);
                }
                buffer.flush();
                byte[] fileBytes = buffer.toByteArray();

                // Convert PDF to DOCX
                ByteArrayInputStream pdfInputStream = new ByteArrayInputStream(fileBytes);
                PDDocument pdf = PDDocument.load(pdfInputStream);
                PDFTextStripper stripper = new PDFTextStripper();
                String text = stripper.getText(pdf);

                XWPFDocument doc = new XWPFDocument();
                XWPFParagraph paragraph = doc.createParagraph();
                String lines[] = text.split("\\r?\\n");
                for (String line : lines) {
                    paragraph.createRun().setText(line);
                }

                ByteArrayOutputStream docOutputStream = new ByteArrayOutputStream();
                doc.write(docOutputStream);
                byte[] docBytes = docOutputStream.toByteArray();

                // Send the DOCX file back to client
                BufferedOutputStream outToClient = new BufferedOutputStream(connectionSocket.getOutputStream());
                outToClient.write(docBytes, 0, docBytes.length);
                outToClient.flush();

                connectionSocket.close();
                System.out.println("File sent back to client.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
