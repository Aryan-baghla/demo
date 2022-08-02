package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "FileController", value = "/FileController")
public class FileController extends HttpServlet {
    private static final String PARENT_PATH = "/Users/manni/Test";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
       if(Objects.equals(path, "null") || path.isEmpty()){
            path = PARENT_PATH ;
        }
        listfiles(path,request, response);

    }

    private void listfiles(String path, HttpServletRequest request, HttpServletResponse response) {
        File filepath = new File(path);
        File filelist[] = filepath.listFiles();
        ArrayList<String> folders = new ArrayList<String>();
        ArrayList<String> files = new ArrayList<String>();
        for(File file : filelist){
            if(file.isDirectory())
                folders.add(file.getName());
            else
                files.add(file.getName());

        }
        request.setAttribute("path",path);
        request.setAttribute("folders",folders);
        request.setAttribute("files",files);
        try {
            getServletContext().getRequestDispatcher("/listFiles.jsp").forward (request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
