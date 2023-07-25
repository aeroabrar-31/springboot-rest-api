package com.restapi.restapis.controllers;

import com.restapi.restapis.helpers.fileuploadhelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private fileuploadhelper helper;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadfile(@RequestParam("file")MultipartFile file)
    {
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());


        if(file.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The file is empty !");
        }

        if(!file.getContentType().equals("image/jpeg"))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The file is of diiferent format !!");
        }

        //file upload code
       boolean f= helper.upload(file);

        if(f)
        {
            return ResponseEntity.ok("working !!");
        }


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not uploaded !");
    }
}
