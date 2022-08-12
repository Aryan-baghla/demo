package com.example.demo;


import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UploadController", value = "/UploadController")
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

        try {

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            request.setAttribute("path", path);
            getServletContext().getRequestDispatcher("/FileController").forward(request,response);
        }

    }
}
