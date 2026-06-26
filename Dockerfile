FROM eclipse-temurin:21-jdk
WORKDIR /app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
EXPOSE 80
ENTRYPOINT java -Doracle.jdbc.timezoneAsRegion=false -Duser.timezone=Asia/Seoul -Djasypt.encryptor.password=${JASYPT_PASSWORD} -Dfile.path=/uploadtest/ -jar  app.jar
