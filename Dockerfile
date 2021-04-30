FROM openjdk:11-jdk

RUN mkdir /app
COPY ./build/install/ktor-movies/ /app/
WORKDIR /app/bin

ENV JAVA_OPTS="-Xmx128M -Xms64M"

CMD ["./ktor-movies"]