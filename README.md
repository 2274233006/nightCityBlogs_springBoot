<div style="filter: grayscale(100%)">
<div align="center">
<img src="https://nightcityblogs-1312951467.cos.ap-shanghai.myqcloud.com/logo.jpg"/ >
<h1>nightCityBlogs</h1>
<h3>致力于促进技术交流和知识共享</h3>
</div>

### 功能特点

- 🥳 前后端免费开源可商用
- 😏集成redis
- 😃前端使用Vue3+create-vue搭建，后端使用SpringBoot+maven搭建，项目结构简单明了
- 😍集成腾讯云COS对象存储
- 😻小白一塌糊涂的屎山代码（这是特色）

### 技术栈——后端

- 简介

  基于SpringBoot搭建，使用maven进行管理，sa-token，redis等完善项目，具体技术栈如下：

  SpringBoot-2.7.10、mybatis、mysql、redis、cos_api、tomCat、springMVC、jdk1.8、MD5加密

### 安装和使用

请先安装JDK1.8版本

数据库文件在这儿:[nightCityBlogsSQL](https://github.com/2274233006/nightCityBlogs_springBoot/blob/master/nightCityBlogsSQL.md)，记得先把表建好，名字字段什么的对应就行，我用的是mysql5.7的版本，如果使用高版本可能会有语法错误问题，自行解决🐕，redis和COS的配置在yml中有描述，也可以参考一些技术博客进行更改

本项目使用maven进行管理

1. 克隆项目到本地

   ```cmd
   git clone https://github.com/2274233006/nightCityBlogs_springBoot.git
   ```

2. 安装项目依赖（maven自动安装）

3. 修改application.yml中redis、mysql的配置，以及utils中COSUploadUtil类中的配置，有注释哦

4. 启动项目前确保你已经部署完Mysql、redis、COS等

5. SpringBoot，启动！

#### 文件结构

- src  —— 主要代码
  - main
    - java
      - nightCityBlogs
        - controller  ——  controller层
        - mapper  ——  Dao层
        - pojo  ——  model层
        - service  ——  service层
        - utils  ——  各种工具类
  - resources  ——  静态资源及Mapper

### 贡献指南

- 主要贡献者：[fengziye](https://github.com/fengziye)，[Gblog](https://github.com/fengziye/Gblog)   前端大部分代码基于这个博客模板，在样式方面基本没有修改，在这里也非常感谢fengziye提供的开源项目，写CSS真的太折磨人了
- CSDN、博客园、知乎、腾讯云开发者平台等多个平台的bug解决方案，也为我提供了很大的帮助，面向百度编程就是我

#### 联系方式

项目部署较为简单，but我是个刚入行的新人，难免有出bug的地方，还请各位大佬见谅😭，非常欢迎大佬提出宝贵建议和意见，我的邮箱地址，看到一定会回复，再次感谢！

- 2274233006@qq.com
- Z1312f73@outlook.com

#### 开源协议

本项目使用[MIT](https://gitee.com/NightCityDemo/nightcityblogs_spring-boot/blob/master/LICENSE)协议
