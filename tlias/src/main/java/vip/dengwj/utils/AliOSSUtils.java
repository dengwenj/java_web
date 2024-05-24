package vip.dengwj.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

// 控制反转
@Component
public class AliOSSUtils {
    // @Value 注解通常用于外部配置的属性注入
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    public String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        int idx = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(idx);
        String newFileName = UUID.randomUUID() + suffix;

        // 这两步主要
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传
        ossClient.putObject(bucketName, newFileName, file.getInputStream());

        String[] split = endpoint.split("//");
        String newEndpoint = split[0] + "//" + bucketName + "." + split[1];
        return newEndpoint + "/" + newFileName;
    }
}
