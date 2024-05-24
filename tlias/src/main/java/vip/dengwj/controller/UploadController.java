package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.dengwj.pojo.Result;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}",file);
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        // 新的文件名
        String newName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        // 将文件存储到磁盘
        file.transferTo(new File("/Users/dengwenjie/Desktop/" + newName));
        return Result.success();
    }
}
