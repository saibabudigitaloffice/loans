FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven \
    && mvn clean package -DskipTests \
    && rm -rf /root/.m2/repository

# Run the Spring Boot app
CMD ["java", "-jar", "/app/target/demo-0.0.1-SNAPSHOT.jar"]
