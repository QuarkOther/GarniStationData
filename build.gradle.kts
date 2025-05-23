plugins {
    id("java")
}

group = "JPtesting"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("mysql:mysql-connector-java:8.0.30")
}

tasks.test {
    useJUnitPlatform()
}