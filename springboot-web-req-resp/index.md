## 简单参数
* SpringBoot 方式
* 简单参数：
* 1、参数名与形参变量名相同，定义形参即可接收参数
* 2、如果方法形参名称与请求参数名称不匹配，可以使用 @RequestParam 完成映射
* @RequestParam(name = "age")
* @RequestParam 中的 required 属性默认为 true，代表该请求参数必须传递，如果不传递将报错。如果该参数是可选的，可以将required属性设置为 false

## 简单参数总结
* 1、原始方式获取请求参数：
* Controller 方法形参中声明 HttpServletRequest 对象
* 调用对象的 getParameter(参数名)
* 2、SpringBoot 中接收简单参数
* 请求参数名与方法形参变量名相同
* 会自动进行类型转换
* 3、@RequestParam 注解
* 方法形参名称与请求参数名称不匹配，通过该注解完成映射
* 该注解的 required 属性默认是 true，代表请求参数必须传递