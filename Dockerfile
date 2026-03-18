# Use a valid OpenJDK 17 image
FROM eclipse-temurin:17-jdk

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

# Run your Spring Boot app
CMD ["java", "-jar", "target/loans-0.0.1-SNAPSHOT.jar"]
