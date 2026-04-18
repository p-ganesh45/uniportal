# Step 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# copy your project folder
COPY uniportal ./uniportal

# go inside folder where pom.xml exists
WORKDIR /app/uniportal

RUN mvn clean package -DskipTests

# Step 2: Run
FROM eclipse-temurin:17
WORKDIR /app

COPY --from=build /app/uniportal/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]