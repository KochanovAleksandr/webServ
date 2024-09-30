FROM alpine/git as clone 
WORKDIR /app
RUN git clone https://github.com/KochanovAleksandr/webServ.git

FROM maven:3.9.5-eclipse-temurin-21-alpine as build 
WORKDIR /app
COPY --from=clone /app/webServ /app 
RUN mvn clean package

FROM openjdk:17.0.2-jdk-slim-buster
WORKDIR /app
COPY --from=build /app/target/webServ.jar /app
EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar webServ.jar"]