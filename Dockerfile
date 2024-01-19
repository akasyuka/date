FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/spring-template-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]