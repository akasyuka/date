CI
docker build -t date:1.0 .
docker tag date:1.0 akasyuka/date:1.0
docker push akasyuka/date:1.0

CD
docker run -d -p 80:8080 akasyuka/date:1.0

java -jar date-0.0.1.jar

CD
docker run -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=user -e POSTGRES_DB=db -d postgres:latest
docker exec -it <id или > psql -U user -d db

