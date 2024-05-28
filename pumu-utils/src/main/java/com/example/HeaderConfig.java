package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    @Bean
    //@ConditionalOnMissingBean // 当不存在当前类型的 bean 时，才声明该 bean
    //@ConditionalOnClass(name = "io.jsonwebtoken.Jwts") // 是否有这个字节码文件 当前环境存在指定的这个类时，才声明该 bean
    //@ConditionalOnProperty(name = "key", havingValue = "value") // 配置文件中存在对应的属性和值，才注册 bean 到 ioc 容器
    public HeaderParser headerParser(){
        return new HeaderParser();
    }

    @Bean
    public HeaderGenerator headerGenerator(){
        return new HeaderGenerator();
    }
}
