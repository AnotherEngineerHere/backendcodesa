FROM openjdk:17-jdk

WORKDIR /app

COPY ./target/demo.jar .

CMD ["java", "-jar", "demo.jar"]
