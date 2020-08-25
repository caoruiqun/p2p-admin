
p2p-admin项目部署步骤：

1、将项目导入到idea工具中；
2、在数据库创建一个数据库叫 p2padmin
3、在项目工程下有一个p2padmin.sql脚本，使用该脚本将表和数据导入到p2padmin数据库；
4、在数据库创建一个数据库叫 p2p2
5、在项目工程下有一个p2p2.sql脚本，使用该脚本将表和数据导入到p2p2数据库；
6、修改项目的application.properties中的数据库连接信息配置；
7、运行项目springboot的P2pAdminApplication类的main方法；
8、访问项目，在浏览器地址栏输入：http://localhost:9500/p2p-admin/
9、输入账号：admin 密码：123456 登录系统；




用户模块（登录、权限）
1、用户访问首页 /，会调用IndexController的index方法，该方法会读取cookie中存放的用户名和密码，如果存在，则把用户名和密码放在model中；
2、页面判断model中放置的用户名、密码、自动登录标志isAutoLogin=1，如果符合自动登录isAutoLogin=1，就给用户自动登录；
3、登录的时候，是调用login.js中的login方法，ajax提交登录；
4、如果用户勾选了7天免登录，我们在登录方法中将用户名和密码存入到浏览的cookie中；
5、登录的时候，就调用mybatis查询数据库u_user_info；