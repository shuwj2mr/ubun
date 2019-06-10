package com.example.ubun.utils;

import com.example.ubun.config.common.ResponseUtils;
import com.example.ubun.config.common.ResponseWrapper;
import com.example.ubun.config.value.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//文件上传
@RestController
public class UploadController {
    @Autowired
    private UploadUtils uploadUtils;

    @RequestMapping("/load")
    public String load(){
        return "load....";
    }

    @RequestMapping(value = "/uploadFile")
    public  ResponseWrapper uploadFile(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        try {
            List<MultipartFile> multipartFiles = Arrays.asList (files);

            List<String> list = new ArrayList<> ();
            for (MultipartFile file : multipartFiles) {
                String originalFilename = file.getOriginalFilename ();
                String type = originalFilename.indexOf (".") != -1 ? originalFilename.substring (originalFilename.lastIndexOf (".") + 1, originalFilename.length ()) : null;
                String contextPath = request.getSession ().getServletContext ().getContextPath ();
                String path = contextPath + uploadUtils.getUploadurl ();
                File dir = new File (path);
                if (!dir.exists ()) {
                    dir.mkdirs ();
                }
                path = UUID.randomUUID ().toString ().substring (0, 8) + System.currentTimeMillis () + type;
                file.transferTo (new File (path));
                list.add (path);
            }
            return ResponseUtils.successResponse ("urls", list, "");
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (IllegalStateException e) {
            e.printStackTrace ();
        }
        return ResponseUtils.errorResponse ("");
    }
}
