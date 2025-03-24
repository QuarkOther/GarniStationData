FROM openjdk:21-slim

RUN apt-get update && apt-get install -y curl

ENV JAVA_HOME=/opt/jdk-21
ENV PATH=$JAVA_HOME/bin:$PATH

EXPOSE 8080

COPY build/libs/GarniStationData-1.0.jar /app/app.jar
COPY conf/config.properties /conf/config.properties

RUN curl -o /app/mysql-connector-java-8.0.33.jar https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.33/mysql-connector-java-8.0.33.jar

RUN ls -l /app/mysql-connector-java-8.0.33.jar

ENTRYPOINT ["java", "-cp", "/app/app.jar:/app/mysql-connector-java-8.0.33.jar", "jpWeatherStation.Main"]