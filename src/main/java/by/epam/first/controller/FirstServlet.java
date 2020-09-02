package by.epam.first.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/controller")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mSec = request.getParameter("time");
        float delta = ((float) (System.currentTimeMillis() - Long.parseLong(mSec))) / 1000;
        request.setAttribute("result", delta);
        String but = request.getParameter("Submit");
        try (InputStream inputStream = getClass().getResourceAsStream("/data/dataFile.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            request.setAttribute("fileData", contents);

        }
        request.setAttribute("button", but.toUpperCase());
        request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
