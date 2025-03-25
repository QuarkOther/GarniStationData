# GarniStationData
Getting data from `Garni 1025 arcus` weather station written in Java 21.

## Setup garni station
I have set an ip address for the garni station and I have set the port to 8080.


## Run the project![IMG_4160](https://github.com/user-attachments/assets/6f4fb03c-19c7-4006-805a-9bc1996fc177)

The project is written in Java 21 with IntelliJ IDEA. It uses MySQL as a database and Grafana for visualization.
All the dependencies are managed by Gradle and the project is built using Docker.
To run the project, you need to have Java 21 installed on your machine and docker-compose. 

I recommend using IntelliJ IDEA to run the project, but you can also run it from the command line using gradle.
At first, you need to set up a credentials for the MySQL database and IP:PORT of reading server in `conf/config.properties` file.
Default values are set to localhost and 8080 and for mysql also localhost and 3306, if not set in the file.

```properties
INPUT_IP=10.10.8.23 // IP of the host PC
INPUT_PORT=8080 // Port setup in the garni station
TIMEZONE=Europe/Prague //timezone, so you have the correct time in the database and in the grafana
DB_IP=localhost // IP of the MySQL database (localhost or mysql)
DB_PORT=3306
DB_DATABASE_NAME=weather_data // Name of the database setup in docker-compose.yml
DB_USER=admin // User for the database setup in docker-compose.yml
DB_PASSWORD=mysql // Password for the database setup in docker-compose.yml
```

If you are running it locally, you can use the default values, but it is recommended to change it.

You can run the project by running the following commands in the root directory of the project, first you need to build the project:

```bash
./gradlew clean build test
```

and then you can run the project by running the following command:

```bash
docker-compose up --build
```

It should start the reading server on port 8080 and grafana on port 3000.

## Grafana
In grafana you need to add MySQL data source.

The Grafana web interface should be on `INPUT_IP:3000` and log in with the default credentials (admin:admin). 
Also, it is recommended to change the password after the first login.

Then you can import the dashboard from the file `WeatherData-Grafana_import.json` in the `conf` directory of the project.

Then just edit the view and press run query, if you have correctly set up the mysql input, you should see the data.

Don't forget to save it after you are done, otherwise you will lose the changes after the restart of the grafana.

### Additional information
The mapping in `DataSchema.java` so as `DataWriter.java` file could be specific for your garni station, so you might need to change it.
I recommend check the incoming data from station and change the mapping in the DataSchema file if needed.
If you change it, don't forget to update tests.

TODO:
- [ ] Add data backup from mysql
