FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} post-service-1.0.0.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "post-service-1.0.0.jar"]
