#!/bin/bash
# arret et suppression de tout les conteneurs
docker stop ppe3
docker rm ppe3
# conteneur hébergeant l'application web qui permet l'insertion des nouveaux employés dans l'annuaire
docker run -d --name ppe3 --link ppedb:ppedb ppe3image


