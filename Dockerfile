### Build Stage ###
FROM gradle:jdk21-jammy AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

ARG DB_PASSWORD
ARG DB_URL
ARG DB_USER
RUN gradle build --no-daemon

# Package Stage
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]