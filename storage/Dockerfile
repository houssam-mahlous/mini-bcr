FROM openjdk:11

RUN mkdir /storage/

COPY target/storage-*[0-9T].jar /storage/storage.jar

WORKDIR /storage

CMD ["java", "-jar", "storage.jar"]
