# How to run a project?
* `mvn clean package` : command will automatically build whole project with all included modules. Keep patient, it can take some time.
* `mvn clean package -DskipTests=false` : same thing, but without skipping test cases. You definitely shouldn`t use it. Take longer time.

Congratulations! The first part is done, so all you need is continuing by follow to the next step :)


## Docker-Compose

Compose is a tool for defining and running multi-container Docker applications. With Compose, you use a YAML file to configure your application’s services. Then, with a single command, you create and start all the services from your configuration. To learn more about all the features of Compose, see the [list of features](https://docs.docker.com/compose/overview/#features).

By using the following command you can start up your application:

```sh
docker-compose up
```
You can easily take a time for a cup of coffee or tea while waiting.
Also, you can run docker-compose in detached mode using -d flag, then you can stop it whenever needed by the following command:

```sh
docker-compose stop
```

You can bring everything down, removing the containers entirely, with the down command. Pass `--volumes` to also remove the data volume.

## How to access this service?
All services can be accessed throw the gateway API, using port 8080. Main endpoints is:
* [Authors](http://localhost:8080/authors)
* [Posts](http://localhost:8080/posts)
* [Eureka](http://localhost:8761/)
* [Zipkin](http://localhost:9411/zipkin)
* [Grafana](http://localhost:3000/) -- login and password (admin:admin)
* [Prometheus](http://localhost:9090/)
* [Prometheus logs](http://localhost:8080/actuator/prometheus/)
* [Actuator](http://localhost:8080/actuator/)
* [Health check](http://localhost:8080/actuator/health/)

Else services logins and passwords hardcoded, don`t worry )


## Ports and it`s services:
* 8080  - API Gateway
* 8081  - Author Service
* 8082  - Post Service
* 5432  - Postgres
* 27017 - Mongo
* 8761  - Eureka
* 9411  - Zipkin
* 3000  - Grafana
* 9090  - Prometheus
