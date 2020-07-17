# linux-connector

Published Ports of the different services:
* 8081 --> Connectorservice
* 8082 --> Authservice
* 8083 --> Apiservice

You should have done a ssh connection from the machine to run the ssh command:

ssh user@host -o HostKeyAlgorithms=ssh-rsa

Otherwise there is a unknownHostException

Set environment variable on host machine (variableName = AUTH_URL) for the authservice if not used with docker
Additionally set the variables for the services on the machine where the apiservice runs if not used with docker (variableNames are AUTH_URL and CONN_URL)
The variablenames should be URL:port e.g http://localhost:8082 (authservice)

# Containerization
Run dockerbuild.sh to build the container images
Run docker-compose up -d to create the containers based on images

## API Endpoints
All Endpoints from the different services (same endpoints, same method and same requestbody)

## Connections EndPoints
/connection 

GET --> Get Connections
POST --> Create Connection. Body: Id of the Stored Connection, token
HEAD --> Delete Connection. Body: Id of the Connection, token
PUT --> Add Command. Body: Id of the Connection, command, token


## ConnStore Endpoints
/connstore

GET --> Get Stored Connections
POST --> Add Stored Connection. Body: id, hostname, port, username, password, token
HEAD --> Delete Stored Connection. Body: id, hostname, port, username, password, token


/connstore/STOREID

POST --> Update Stored Connection. Path: storeId (in List), Body: id, hostname, port, username, password


## Authentication EndPoints
/auth

POST (login) --> Body: email, password
PUT (verifyToken) --> Body: Token
