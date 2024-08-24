FROM openjdk:17-jdk-slim

COPY build/libs/moneygement-api-server-0.0.1.jar moneygement-api-server-0.0.1.jar

ENTRYPOINT ["java", "-jar", "app.jar"]