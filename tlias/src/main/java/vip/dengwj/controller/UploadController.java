package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.dengwj.pojo.Result;
import vip.dengwj.utils.AliOSSUtils;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    /**
     * 文件上传
     */
    // 本地存储方式
    //@PostMapping("/upload")
    //public Result upload(MultipartFile file) throws Exception {
    //    log.info("文件上传：{}",file);
    //    // 获取原始文件名
    //    String originalFilename = file.getOriginalFilename();
    //    // 新的文件名
    //    String newName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
    //    // 将文件存储到磁盘
    //    file.transferTo(new File("/Users/dengwenjie/Desktop/" + newName));
    //    return Result.success();
    //}

    // OSS 存储方式
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        log.info("文件上传：{}", file.getOriginalFilename());
        String url = aliOSSUtils.upload(file);
        return Result.success(url);
    }
}
