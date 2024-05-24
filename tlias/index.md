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

## 本地存储
* 在服务端，接收到上传上来的文件之后，将文件存储在本地服务器磁盘中
* 在 Springboot 中，文件上传，默认单个文件允许最大大小为 1M，如果需要上传大文件，可以进行如下配置：
* 配置单个文件最大上传大小：spring.servlet.multipart.max-file-size=10MB
* 配置单个请求最大上传大小（一次请求可以上传多个文件）：spring.servlet.multipart.max-request-size=100MB
* MultipartFile 对象的方法：
* 获取原始文件名：String getOrigininalFilename()
* 将接收的文件转存到磁盘文件中：void transferTo(File dest)
* 获取文件的大小，单位：字节：long getSize()
* 获取文件内容的字节数组：byte[] getBytes()
* 获取接收到的文件内容的输入流：InputStream getInputStream()

## 本地存储缺点
* 无法直接访问，磁盘满了，磁盘坏了

## 配置格式
* Springboot 提供了多种属性配置方式：
* 1、application.properties
* 2、application.yml
* 3、application.yaml

## yml 基本语法
* 大小写敏感
* 数值前边必须有空格，作为分隔符
* 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可
* #表示注释
* server:
*   port: 8080
*   address: 127.0.0.1

## yml 数据格式
* 对象/Map集合：
* user:
*   name: zhangsan
*   age: 18
* 
* 数组/List/Set集合：
* hobby:
*  -空格java
*  -空格c