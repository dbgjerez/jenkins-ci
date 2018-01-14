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
