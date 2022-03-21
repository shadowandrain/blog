#概述
* 使用了ssm+springboot+thymeleaf+maven，拥有用户界面和管理员界面，密码使用工具类进行了加密
* 用户界面相对简单，只是将博文分页显示同时可进行评论及返回登录界面
* 管理员页面实现了发布博文模块+博文管理模块+添加博文分类模块+博文分类管理模块+用户管理模块和返回登录界面
    * 实现了对各模块数据的crud

#导入
* 记得导入时使用maven同时刷新一下

#需做修改部分

### 修改sql连接驱动信息
* 将resources/application.properties进行修改
* 连接驱动版本为5.x的，使用com.mysql.jdbc.Driver，为8.x的，使用com.mysql.cj.jdbc.Driver
    * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
* spring.datasource.url=jdbc:mysql://127.0.0.1:3306/blogdb?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true
* 将root和333改为自己的mysql账号和密码
   * spring.datasource.username=root
   * spring.datasource.password=333
    
## 启动
* 通过BlogApplication文件启动，在浏览器搜索"http://localhost:8080/login/loginPage"
* 有管理员和普通用户两种权限，根据账号密码进行判定，管理员和用户账号密码相同时的判定没做，别试
* 目前用户账号密码1、1，管理员账号密码为2、2
