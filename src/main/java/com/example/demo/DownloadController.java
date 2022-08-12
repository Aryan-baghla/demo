package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DownloadController", value = "/DownloadController")
public class DownloadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("test/html");
        PrintWriter pw = response.getWriter();
        String path = request.getParameter("path");
        String file = request.getParameter("file");

        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"" + file +"\"");

        FileInputStream fis = new FileInputStream(path+ File.separator +file);

        int i;
        while ((i=fis.read()) != -1 ) {
            pw.write(i);

        }
        fis.close();
        pw.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
