package org.project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadGameServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();

                // Set the size threshold after which files will be written to disk
                int fileSizeMax = 10 * 1024 * 1024; // 10 MB as an example limit
                factory.setSizeThreshold(fileSizeMax);
                
                // Specify a temporary directory on the server for file uploads
                String tempDirPath = System.getProperty("java.io.tmpdir");
                File repositoryPath = new File(tempDirPath + File.separator + "temp");
                if (!repositoryPath.exists()) {
                    repositoryPath.mkdirs();
                }
                factory.setRepository(repositoryPath);

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);

                // Parse the request to get file items.
                List<FileItem> items = upload.parseRequest(request);
                
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();

                    if (!item.isFormField()) { // Check if it's a file field
                        String fileName = new File(item.getName()).getName(); // Get file name

                        // Create the destination folder and ensure it exists
                        File destDir = new File(getServletContext().getRealPath("") + "/applets");
                        if (!destDir.exists()) {
                            destDir.mkdirs();
                        }

                        // Save the uploaded file to the specified directory with its original filename
                        File uploadedFile = new File(destDir, fileName);
                        item.write(uploadedFile);

                        response.getWriter().println("File " + fileName + " has been uploaded successfully.");
                    }
                }
            } catch (FileUploadException ex) {
                logger.log(Level.SEVERE, null, ex);
                response.getWriter().println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                logger.log(Level.SEVERE, null, ex);
                response.getWriter().println("An error occurred. Details in server logs.");
            }
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadGameServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadGameServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private static final Logger logger = Logger.getLogger(UploadGameServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    public static void main(String[] args) {
    }
}