# 使用官方OpenJDK作为基础镜像
FROM openjdk:11-jdk-slim as build

# 设置工作目录
WORKDIR /app

# 复制JAR文件到容器中
COPY target/*.jar dust.jar

# 暴露应用程序运行端口
EXPOSE 7861

# 运行Spring Boot应用程序
CMD ["java", "-jar", "/app/dust.jar"]
