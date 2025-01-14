package org.forstackoverflow;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ArticlesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Default to main.jsp for the base URL without additional path
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/articles/main.jsp");
            dispatcher.forward(request, response);
        } else {
            switch (pathInfo) {
                case "/main":
                    RequestDispatcher dispatcherMain = request.getRequestDispatcher("/WEB-INF/articles/main.jsp");
                    dispatcherMain.forward(request, response);
                    break;
                // Add more cases as needed
                default:
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if necessary
        doGet(request, response); // Or implement specific logic for POST
    }

    public static void main(String[] args) {
    }
}