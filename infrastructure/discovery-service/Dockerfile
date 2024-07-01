FROM maven:3.8.6-openjdk-11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery-service-1.0.0.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "discovery-service-1.0.0.jar"]