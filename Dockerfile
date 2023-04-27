FROM openjdk:21-ea-13-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
