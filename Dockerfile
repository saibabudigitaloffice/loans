# Use OpenJDK 17 slim version
FROM openjdk:17-slim

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies first (caching)
COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Copy all source code
COPY src ./src

# Package the application
RUN mvn clean package

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Command to run your Spring Boot app
CMD ["java", "-jar", "target/loans-0.0.1-SNAPSHOT.jar"]
