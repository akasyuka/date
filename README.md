CI
docker build -t date:1.4 .
docker tag date:1.4 akasyuka/date:1.4
docker push akasyuka/date:1.4

local
java -jar date-0.0.1.jar
docker run -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=user -e POSTGRES_DB=db -d postgres:latest
docker exec -it <id или > psql -U user -d db

remote
docker network create my_network
docker run --name postgres-container --network my_network -d -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=user -e POSTGRES_DB=db postgres:latest
docker run --name spring-app-container --network my_network -d -p 80:80  -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres-container:5432/db -e SPRING_DATASOURCE_USERNAME=user -e SPRING_DATASOURCE_PASSWORD=user akasyuka/date:1.4



