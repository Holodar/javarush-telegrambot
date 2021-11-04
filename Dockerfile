FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.javarush_tornike_bot
ENV BOT_TOKEN=1995598144:AAF1H3Aielk3C2YXqM3fr2CFULaHoX2A1vI
ENV BOT_DB_USERNAME=jrtb_db_user
ENV BOT_DB_PASSWORD=jrtb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar", "javarush.api.path=https://javarush.ru/api/1.0/rest"]