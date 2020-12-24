sme-wsl小组数据库大作业

——前后端代码部分

项目后端主要以springboot为框架，前端使用thymeleaf渲染html，运用mysql数据库并连接、同步。

项目部署在阿里云服务器上并长久运行，可以使用<http://8.210.115.67:8080/>访问登录界面。

项目上传到github上（https://github.com/youdu6/sml-wsl）

一、整体框架

![](media/93b3fd0092521928b152e0107c8fa47b.png)

![](media/be2779f7f82ac98d55200b4a762336ee.png)

二、后端（java+springboot+mybatis+mysql）

![](media/5d7fdc5cdb9ed691ec5aabd3d6d37a64.png)


component与config为网站后端配置

![](media/e674b7043d43c908b9e6332e9531d04f.png)


Controller包为网站后端配置（响应http），并完成一部分前端数据操作

![](media/8fc98d8c345f3c0bd726c2994c1a87e0.png)


dao包为实体属性操作与后端数据库操作（增删改查等）

![](media/4fb8535c977e8653f13cc1a05488e52f.png)


entities为实体包，完成实体属性与基本函数

![](media/be1bfc4c95b1327b2b07a5caa1aeec18.png)


mapper包使用mybatis完成对mysql数据库的操作

![](media/bfd5779493cff3680b1950f10b81dcbd.png)


为springboot项目启动类

三、前端（html+css+JavaScript+thymeleaf+webjar）

![](media/d015878484a214991198d7ec9565b9d1.png)


resources文件夹为非java代码，包括mysql，html，css，properties，yml，JavaScript，ico图片

![](media/ed27f183cf2855e4b3a17e3f8d133002.png)


为网页图片

![](media/439304ba4578852dbb90236d5ed4ad38.png)


为mysql代码，包括建表与插入初始测试数据

![](media/7b6b7d933c658f07749c24614d290215.png)


为网站前端样式，借用webjar的jquery与bootstrap样式

![](media/c81c73741cd7790db3e82425de163602.png)


为网站前端html代码

![](media/9080f412fdeb9b18c55feb6f786f0bd0.png)

为网站通用html，如侧边栏与顶部栏

![](media/a94c861e047514243f16e636d6dbb5db.png)

为游戏的前端操作，如增加、购买、（生产商与用户）游戏列表、搜索列表

![](media/8cead2f9468381f93df510245a1af066.png)

为公告前端界面

![](media/8df6f6af3e1739688d0fe0a9385cdea1.png)

为订单前端

![](media/7f178146ae85f5ae1688a2e35cb0b3b1.png)

分别为购物车、评论列表、评论、主页、登录与注册页面

![](media/5c4e76bb6202ce27823875b74d9bd7fc.png)

为配置文件，包括springboot配置与远程mysql数据库连接

四、测试

![](media/ce6b94dd0535a725607fd13e21f39d08.png)

test包主要为测试数据库连接

五、依赖

![](media/be2779f7f82ac98d55200b4a762336ee.png)

为springboot依赖配置
