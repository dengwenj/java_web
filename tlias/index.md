## 文件上传
* 文件上传，是指将本地图片、视频、音频等文件上传到服务器，供其他用户浏览或下载的过程。
* Springboot 文件上传用 MultipartFile 形参类型
```java
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
```