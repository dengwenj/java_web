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

## 依赖范围
* 依赖的 jar 包，默认情况下，可以在任何地方使用。可以通过<scope>...</scope> 设置其作用范围
* 作用范围：
* 主程序范围有效。（main 文件夹范围内）
* 测试程序范围有效。（test 文件夹范围内）
* 是否参与打包运行。（package 指令范围内）
* scope 值        主程序        测试程序       打包(运行)      范例
* compile(默认)     Y             Y            Y            log4j
* test             N             Y             N            junit
* provided         Y             Y             N            servlet-api
* runtime          N             Y             Y            jdbc 驱动

## Maven 生命周期
* Maven 的生命周期就是为了对所有的 maven 项目构建过程进行抽象和统一

## Maven 中有 3 套相互独立的生命周期
* clear：清理工作
* default：核心工作，如：编译、测试、打包、安装、部署等
* site：生成报告、发布站点等
* 每套生命周期包含一些阶段，阶段是有顺序的，后面的阶段依赖于前面的阶段

## 声明周期阶段
* clear：移除上一次构建生成的文件
* compile：编译项目源代码
* test：使用合适的单元测试框架运行测试
* package：将编译后的文件打包，如：jar、war等
* install：安装项目到本地仓库
* 在同一套生命周期中，当运行后面的阶段时，前面的阶段都会运行

## 执行指定生命周期的两种方式
* 在 idea 中，右侧的 maven 工具栏，选中对应的生命周期，双击执行
* 在命令行中，通过命令执行 -> mvn compile

## Spring
* Spring 是一个开源的java平台，提供了一种全面的编程和配置模型，用于构建企业级应用程序
* Spring 提供了若干个子项目，每个项目用于完成特定的功能

## SpringBoot
* SpringBoot 是 Spring 下的一个子项目，可以帮助我们非常快速的构建应用程序、简化开发、提高效率