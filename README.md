# linux-connector


You should have done a ssh connection from the machine to run the ssh command:

ssh user@host -o HostKeyAlgorithms=ssh-rsa

Otherwise there is a unknownHostException

Set environment variable on host machine (variableName = AUTH_URL) for the authservice if not used with docker


## Connections EndPoints
/connection 

GET --> Get Connections
POST --> Create Connection. Body: Id of the List in Stored Connection, token
DELETE --> Delete Connection. Body: Session (toString)), token
PUT --> Add Command. Body: Session (toString)), command, token


## ConnStore Endpoints
/connstore

GET --> Get Stored Connections
POST --> Add Stored Connection. Body: hostname, port, username, password, token
DELETE --> Delete Connection. Body: hostname, port, username, password, token


/connstore/STOREID

POST --> Update Stored Connection. Path: storeId (in List), Body: hostname, port, username, password


## Authentication EndPoints
/auth

POST (login) --> Body: email, password
PUT (verifyToken) --> Body: Token
