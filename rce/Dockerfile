# Stage 1: Build the JAR using Maven and Java 21
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app
COPY . .

# Optional: use Maven wrapper if present, or system Maven
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the app with a lightweight Java 21 image
FROM eclipse-temurin:21-jdk-jammy as runner

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
