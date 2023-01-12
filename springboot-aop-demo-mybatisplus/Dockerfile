# 该镜像需要依赖的基础镜像
FROM openjdk:8-jdk-alpine
# 声明服务运行在8080端口
EXPOSE 80
# 将当前目录下的jar包复制到docker容器的/目录下
ADD ./target/springboot-aop-demo-mybatisplus.jar springboot-aop-demo-mybatisplus.jar
# 指定临时文件目录
VOLUME /tmp
# 项目配置的日志文件目录
VOLUME /logs
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java","-jar","/springboot-aop-demo-mybatisplus.jar"]
# 指定时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 指定维护者的名字
MAINTAINER hichaoren