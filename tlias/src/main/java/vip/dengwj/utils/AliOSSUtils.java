package vip.dengwj.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

// 控制反转
//@Data
@Component
//@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSUtils {
    // @Value 注解通常用于外部配置的属性注入
    // @Value("${aliyun.oss.endpoint}")
    //private String endpoint;
    //private String accessKeyId;
    //private String accessKeySecret;
    //private String bucketName;
    @Resource
    AliOSSProperties aliOSSProperties;

    public String upload(MultipartFile file) throws IOException {
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();
        String bucketName = aliOSSProperties.getBucketName();

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
