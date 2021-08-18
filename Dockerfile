FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.javarush_tornike_bot
ENV BOT_TOKEN=1995598144:AAF1H3Aielk3C2YXqM3fr2CFULaHoX2A1vI_uso
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]