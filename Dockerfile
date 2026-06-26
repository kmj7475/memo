FROM eclipse-temurin:21-jdk
WORKDIR /app
# gradle : -plain.jar가 아닌 일반 실행 가능 jar만 매칭되도록 변경
ARG JAR_FILE=build/libs/*[!plain].jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
EXPOSE 80
ENTRYPOINT java -Doracle.jdbc.timezoneAsRegion=false -Duser.timezone=Asia/Seoul -Djasypt.encryptor.password=${JASYPT_PASSWORD} -Dfile.path=/uploadtest/ -jar  app.jar
