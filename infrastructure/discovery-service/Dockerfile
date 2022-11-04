FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery-service-1.0.0.jar
ENTRYPOINT ["java", "-jar", "discovery-service-1.0.0.jar"]