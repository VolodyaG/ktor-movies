## Ktor Backed example

Ktor, Exposed, Jackson, Logback

`./gradlew run`

### Docker

```shell
./gradlew installDist
docker build -t volodya/ktor-movies:1 .
docker push volodya/ktor-movies:1
```

```shell
docker run --name ktor-movies -p 8080:8080 -d \
-e DB_URL=jdbc:postgresql://10.10.10.10:5432/movies_db \
-e DB_USER=postgres \
-e DB_PASSWORD=admin \
volodya/ktor-movies:1
```

#### Queries

* http://127.0.0.1:8080/movies
* http://127.0.0.1:8080/movies/19995

