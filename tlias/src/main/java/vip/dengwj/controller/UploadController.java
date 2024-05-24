package vip.dengwj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.dengwj.pojo.Result;

@Slf4j
@RestController
public class UploadController {
    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public Result upload(String name, String password, MultipartFile file) {
      log.info("文件上传：{}, {}, {}", name, password, file);

      return Result.success();
    }
}
