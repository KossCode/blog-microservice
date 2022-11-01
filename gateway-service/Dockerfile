FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway-service-1.0.0.jar
ENTRYPOINT ["java", "-jar", "gateway-service-1.0.0.jar"]