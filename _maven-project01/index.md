## maven
* src -> main -> java 存放的是 java 源代码
* src -> main -> resources 存放的是配置文件

## Maven 坐标
* Maven 中的坐标是资源的唯一标识，通过该坐标可以唯一定位资源位置
* 使用坐标来定义项目或引入项目中需要的依赖

## Maven 坐标主要组成
* groupid：定义当前 Maven 项目隶属组织名称（通常是域名反写，例如：vip.dengwj）
* artifactid：定义当前 Maven 项目名称（通常是模块名称，例如 order-service、goods-service）
* version：定义当前项目版本号

## 依赖配置
* 依赖：指当前项目运行所需要的 jar 包，一个项目中可以引入多个依赖
* 1、在 pom.xml 中编写 <dependencies> 标签
* 2、在 <dependencies> 标签中使用 <dependency> 引入坐标
* 3、定义坐标的 groupId，artifactId，version
* 4、点击刷新按钮，引入最新加入的坐标
* 如果引入的依赖在本地仓库不存在，将会连接远程仓库/中央仓库，然后下载依赖

## 依赖传递
* 依赖具有传递性
* 直接传递：在当前项目中通过依赖配置建立的依赖关系
* 间接传递：被依赖的资源如果依赖其他资源，当前项目间接依赖其他资源

## 排除依赖
* 排除依赖指主动断开依赖的资源，被排除的资源无需指定版本
* <exclusions><exclusion><groupid></groupid><artifactid></artifactid></exclusion></exclusions>