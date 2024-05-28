package vip.dengwj.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 这里定义一个类的原因是：可以有很多地方都要使用，进行封装复用
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    // 属性名要和配置文件中的一样
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
