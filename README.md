# Jenkins Continous Integration

# Getting Started
* Init Docker Swarm
```bash
docker swarm init
```
* Create secrets

   You should create your credentials as a Docker secret. These can be created from a file, command line, etc. In this example we use admin/admin but you should use different stronger credentials in production installation.
```bash
echo "admin" | docker secret create jenkins-user -
echo "admin" | docker secret create jenkins-pass -
```

* Starts services
   Now, it are going to start the different services defined in our swarm's file:
```bash
docker stack deploy -c docker-swarm.yml ci
```

* Stops services
   We can stop all our services under ci's stack with the following command:
```
docker stack rm ci
```

* Finish Docker Swarm
   When we like delete the Docker's Swarm service we have to write the next sentence:
```
docker swarm leave -f
```
