package vip.dengwj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.dengwj.AliOSSUtils;

import java.io.IOException;

@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        System.out.println("aliOSSUtils" + aliOSSUtils);
        String upload = aliOSSUtils.upload(file);
        System.out.println(file.getOriginalFilename());
        return upload;
    }
}
