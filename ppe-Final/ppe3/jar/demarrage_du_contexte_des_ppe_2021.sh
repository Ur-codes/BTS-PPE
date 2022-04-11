#!/bin/bash
# arret et suppression de tout les conteneurs
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
# suppression des volumes docker
docker volume rm $(docker volume ls)
# conteneur hébergeant la base de données annuaireDB
docker run -d --name ppedb -e POSTGRES_USER=ppe -e POSTGRES_PASSWORD=ppe -e POSTGRES_DB=annuaireDB postgres
#temporistation de 15 secondes
sleep 15s
# exécution des applications ppe1 et ppe2 sous forme de jar exécutables
java -jar ppe1.jar
java -jar ppe2.jar
#temporistation de 10 secondes
sleep 10s
# conteneur hébergeant l'application web qui permet l'insertion des nouveaux employés dans l'annuaire
docker run -d --name ppe3 --link ppedb:ppedb jsftuto
# conteneur de supervision (portainer) des conteneurs Docker (interface de supervision http://172.17.0.x:9000)
docker run -d --name portainer --privileged -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock -v /opt/portainer:/data portainer/portainer-ce


