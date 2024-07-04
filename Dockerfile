# Use OpenJDK 21 slim for smaller image size
FROM openjdk:21-jdk-slim

# Argument to specify build artifact
ARG JAR_FILE=target/*.jar

# Copy the jar file to the container
COPY ${JAR_FILE} app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
