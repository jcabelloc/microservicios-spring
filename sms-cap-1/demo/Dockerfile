FROM openjdk:11.0.4-jre
MAINTAINER Juan Cabello <jcabelloc@itana.pe>

ENTRYPOINT ["java", "-jar", "/usr/share/serviciodemo/serviciodemo.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/serviciodemo/serviciodemo.jar