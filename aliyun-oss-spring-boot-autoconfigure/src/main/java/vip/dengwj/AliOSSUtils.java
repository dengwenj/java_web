package vip.dengwj;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

// 控制反转
//@Data
//@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSUtils {
    // @Value 注解通常用于外部配置的属性注入
    // @Value("${aliyun.oss.endpoint}")
    //private String endpoint;
    //private String accessKeyId;
    //private String accessKeySecret;
    //private String bucketName;
    AliOSSProperties aliOSSProperties;

    public AliOSSProperties getAliOSSProperties() {
        return aliOSSProperties;
    }

    public void setAliOSSProperties(AliOSSProperties aliOSSProperties) {
        this.aliOSSProperties = aliOSSProperties;
    }

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
