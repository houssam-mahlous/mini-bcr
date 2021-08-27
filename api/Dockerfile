FROM openjdk:11

RUN mkdir /api/

COPY target/api-*[0-9T].jar /api.jar

ENV HTTP_PORT 8080

EXPOSE ${HTTP_PORT}

CMD ["java", "-jar", "api.jar"]
