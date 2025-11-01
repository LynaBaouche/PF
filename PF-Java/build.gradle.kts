plugins {
    id("java")
    id("application")
}
application {
    mainClass.set("org.example")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("io.vavr:vavr:0.10.4")
    implementation("org.apache.logging.log4j:log4j-api:2.19.0")
    implementation("org.apache.logging.log4j:log4j-core:2.19.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.1")

}

tasks.test {
    useJUnitPlatform()
}