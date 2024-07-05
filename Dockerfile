# Use Amazon Corretto as the base image
FROM amazoncorretto:21

# Set the working directory in the Docker container
WORKDIR /app

# Copy the JAR file from your target directory to the Docker container
COPY ./target/docker-3.3.3.jar /app/springboot-app.jar

# Expose the port that your Spring Boot application uses
EXPOSE 8080

# Command to run your Spring Boot application
CMD ["java", "-jar", "springboot-app.jar"]
