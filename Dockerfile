FROM openjdk:17-alpine
VOLUME /tmp
VOLUME /X/attachments
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Djava.awt.headless=true", "-Duser.home=/tmp", "-jar","/app.jar"]
