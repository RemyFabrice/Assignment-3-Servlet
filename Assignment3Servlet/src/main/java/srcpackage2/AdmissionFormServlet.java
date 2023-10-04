package srcpackage2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
        maxFileSize = 1024 * 1024 * 5, 
        maxRequestSize = 1024 * 1024 * 5 * 5) 
public class AdmissionFormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        Part passwordPicturePart = request.getPart("passwordPicture");
        Part certificatePart = request.getPart("certificate");

        
        String passwordPictureFileName = processFile(passwordPicturePart, "jpg", "png");
        String certificateFileName = processFile(certificatePart, "pdf");

      
    }

    
    private String processFile(Part part, String... allowedExtensions) throws IOException {
        String submittedFileName = part.getSubmittedFileName();

        
        boolean isAllowed = false;
        for (String extension : allowedExtensions) {
            if (submittedFileName.endsWith("." + extension)) {
                isAllowed = true;
                break;
            }
        }

        if (!isAllowed) {
           
            return null;
        }

       
        try (InputStream inputStream = part.getInputStream()) {
            
            String saveDirectory = "your/save/directory/path";
            Path file = Path.of(saveDirectory, submittedFileName);

            
            Files.copy(inputStream, file, StandardCopyOption.REPLACE_EXISTING);

           
            return submittedFileName;
        }
    }
}

