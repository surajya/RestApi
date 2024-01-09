package com.book.booktest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.booktest.helper.fileUploadHelper;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    fileUploadHelper fileUploadHelper1;
    public FileUploadController(fileUploadHelper fuh){
        this.fileUploadHelper1=fuh;
    }
    @PostMapping
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must have file");
        }

        if(fileUploadHelper1.fileUpload(file)) return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
