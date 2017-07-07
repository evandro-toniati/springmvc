package org.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
    
    @Value("${upload.path}")
    private String diskpath; 

    public String write(String baseFolder, MultipartFile file) {
        try {
//            String realPath = request.getServletContext().getRealPath("\\"+baseFolder);
//            System.out.println("realPath = " + realPath);
            String path = diskpath + "\\" + file.getOriginalFilename();
            System.out.println("path = " + path);
            file.transferTo(new File(path));
            return path;

        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}