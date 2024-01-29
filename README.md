# ci/cd
docker build -t date:1.13 .
docker tag date:1.13 akasyuka/date:1.13
docker push akasyuka/date:1.13

# local
docker run -d -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=user -e POSTGRES_DB=db postgres:latest
run app

# remote
docker run --network host -d -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=user -e POSTGRES_DB=db postgres:latest
docker run --network host -d -p 8080:8080 akasyuka/date:1.13

docker exec -it 40f229ab6673 psql -U user -d db

