FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-server-1.0.0.jar
ENTRYPOINT ["java", "-jar", "config-server-1.0.0.jar"]