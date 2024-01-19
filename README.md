CI
docker build -t spring-template:1.0 .
docker tag spring-template:1.0 akasyuka/spring-template:1.0
docker push akasyuka/spring-template:1.0

CD
docker run -- name appName -d -p 80:8080 akasyuka/spring-template:1.0

java -jar trading-bot-1.0-SNAPSHOT.jar

CD
docker run --name postgresName -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=user -e POSTGRES_DB=db -d postgres:latest
docker exec -it postgresName psql -U user -d db

