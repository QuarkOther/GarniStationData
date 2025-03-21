FROM openjdk:21-slim

RUN apt-get update

ENV JAVA_HOME=/opt/jdk-21
ENV PATH=$JAVA_HOME/bin:$PATH

COPY build/libs/GarniStationData-1.0.jar /app/app.jar
COPY conf/config.properties /conf/config.properties

ENTRYPOINT ["java", "-cp", "/app/app.jar", "jpWeatherStation.Main"]