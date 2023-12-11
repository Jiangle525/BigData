开发大致流程：
1. 明确需求
2. 制定/阅读接口文档
3. 思路分析
4. 编码实现
5. 测试

创建项目的过程：
1. 创建SpringBoot项目(BigEvent)，导入对应的起步依赖（web、mybatis）
2. 创建pojo、mapper、service、controller、utils
3. 创建数据库和表，并自动生成实体类存放至`bigevent.pojo`目录下，可以给实体类添加@Data在编译阶段会自动生成getter、setter、equals、toString等方法
4. controller -> service -> mapper
   1. controller:
      1. 参数校验：
         - 导入坐标spring-boot-starter-validation的注解
         - 在Controller类上添加注解@Validated
         - 在Handler方法参数前添加@Pattern
         - 添加一个全局异常处理，处理参数校验失败的异常
         - 实体参数校验：在实体类上添加注解，如@NotNull、@Pattern，在接口方法上添加@Validated注解
      2. 权限校验（在拦截器中实现，并定义一个配置类添加拦截器，登录和注册接口除外）
         - jwt令牌(token)的组成：header(头部)、payload(载荷)、signature(签名)
         - jwt令牌的使用：引入坐标、调用API生成令牌、解析令牌（抛出异常则说明验证失败）
      3. 可以通过@JsonIgnore让SpringMVC返回实体类对象的时候忽略某个属性
      4. 可以使用ThreadLocal来存储线程局部变量，在拦截器的在preHandle中存值，在afterCompletion中释放内存
      5. 请求内容：
         - 如果请求内容在Body中，以application/json格式传递，则可以通过@RequestBody进行解析，自动将Json格式的字符串解析为Java对象
         - 如果请求内容在Body中，以x-www-form-urlencoded格式传递，则可以通过@ModelAttribut进行解析，可以将参数封装到Java类中
         - 如果请求内容在Params中，则通过@Params进行解析，需要手动解析参数



2023-12-05 21:25:20  已完成UserController和CategoryController
2023-12-11 18:27:16  已完成ArticleController
