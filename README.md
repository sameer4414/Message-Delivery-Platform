# Message Delivery Platform

## Structure

Created 2 docker based microservices
1. mdp-frontend (JSON)
2. mdp-backend (JSON)

The 2 microservices interact via Camel message transformation and processing

Both mdp-frontend and mdp-backend are JSON based ReST ful microservices
Leveraging Camel and Docker 

## Message validation
The validation of the JSON message is done using json schema via spring based validator

## Message processing and transfomration
The mdp-frontend receives the "message" json - transforms (and also processes message) it into "information" json to be
consumed by the backend.

The mdp-frontend receives the "information" json - transforms (and also processes information) it into "message" to be persisted
into the database and same is sent back to be displayed by the mdp-frontend


## Endpoints
The relavant endpoints are :

http://localhost:8080/messages

http://localhost:8181/information
