# Simple project image build:
    docker build -t ua.koss/author-service .

# Postgre SQL database container can be run from following command:
    docker run -p 5432:5432 --name author-service-database -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=docker -e POSTGRES_DB=author-service postgres:13.1-alpine

* * *

Useful docker command:
* `docker container ls -a`: to display all stored containers
* `docker stop containerID`: to stop chosen container
* `docker container rm containerID`: to remove container with chosen ID
* `docker image ls -a`: to display all stored images

* * *

# How to run all together in one command:
* `docker compose up` : command runs process to build project > create it`s image, and run together with database