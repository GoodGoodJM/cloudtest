FROM eclipse-temurin:17-jre-focal
COPY eureka/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
