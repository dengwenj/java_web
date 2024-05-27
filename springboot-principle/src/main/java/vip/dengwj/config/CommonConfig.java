package vip.dengwj.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 配置类
public class CommonConfig {
    // 将当前方法的返回值对象交给 IOC 容器管理，成为 IOC 容器 bean
    // 通过 @Bean 注解的 name/value 属性指定 bean 名称，如果未指定，默认是方法名
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }
}
