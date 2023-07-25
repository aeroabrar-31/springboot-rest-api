package com.restapi.restapis.helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Component
public class fileuploadhelper {
    public String upload_dir="C:\\Users\\SHAIK ABRAR UL HAQ\\Downloads\\restapis\\restapis\\src\\main\\resources\\static\\images";

    public boolean upload(MultipartFile file)
    {
        boolean flag=false;
        try
        {
//            Files.copy(file.getInputStream(),upload_dir+file.getOriginalFilename(), StandardCopyOption.REPLACE_EXISTING);

            InputStream is=file.getInputStream();
            byte data[]=new byte[is.available()];
            is.read(data);

            FileOutputStream fo=new FileOutputStream(upload_dir+file.getOriginalFilename());
            fo.write(data);
            fo.close();
            flag=true;




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }


}
