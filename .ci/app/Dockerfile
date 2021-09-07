FROM gcr.io/distroless/java:11
ARG JAR_FILE=./dbpoc.jar
COPY ../../${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]