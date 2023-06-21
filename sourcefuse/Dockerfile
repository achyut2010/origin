FROM openjdk:17-oracle
WORKDIR /tmp
ADD target/sourcefuse-0.0.1.jar app.jar
EXPOSE 8084 8083
ENTRYPOINT ["java", "-jar", "app.jar"]