FROM openjdk17:alpine
VOLUME /tmp
VOLUME /X/attachments
RUN apk update && apk add libxext
ENV LD_LIBRARY_PATH="/usr/lib"
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
