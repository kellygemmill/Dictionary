# Build the Spring Boot API
FROM maven:3.6.3-openjdk-11-slim AS builder
ADD . ./
RUN mvn -f pom.xml clean package -e -DskipTests

# Final Stage Build
FROM openjdk:11-jre-slim
COPY --from=builder /target/dictionary-0.0.1-SNAPSHOT.jar /demo.jar
EXPOSE 8080
CMD ["java", "-jar", "/demo.jar"]