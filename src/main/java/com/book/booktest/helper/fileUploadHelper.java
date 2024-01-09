package com.book.booktest.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadHelper {

    //public final String path_dir="D:\\JAVA\\SpringBoot\\VS cODE\\book\\src\\main\\resources\\static\\image";

    public boolean fileUpload(MultipartFile multipartFile){
        boolean f=false;
        try {
            final String path_dir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
            Files.copy(multipartFile.getInputStream(), Paths.get(path_dir+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return f;
        
    }
}
