FROM openjdk:11 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY covid-api/build.gradle covid-api/settings.gradle covid-api/gradlew $APP_HOME
COPY covid-api/gradle $APP_HOME/gradle
COPY . .
RUN chmod +x ./gradlew build -x test
#justePourTesterSurMogeniusInternetcsfszgzr
FROM openjdk:17
ENV ARTIFACT_NAME=covid-api-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
EXPOSE 8080
CMD ["java","-jar","/usr/app/covid-api-0.0.1-SNAPSHOT.jar"]
