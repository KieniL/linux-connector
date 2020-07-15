# linux-connector


You should have done a ssh connection from the machine to run the ssh command:

ssh user@host -o HostKeyAlgorithms=ssh-rsa

Otherwise there is a unknownHostException


## Connections EndPoints
/connection 

GET --> Get Connections
POST --> Create Connection. Body: Id of the List in Stored Connection
DELETE --> Delete Connection. Body: Session (toString))
PUT --> Add Command. Body: Session (toString)), command


## ConnStore Endpoints
/connstore

GET --> Get Stored Connections
POST --> Add Stored Connection. Body: hostname, port, username, password
DELETE --> Delete Connection. Body: hostname, port, username, password


/connstore/STOREID

POST --> Update Stored Connection. Path: storeId (in List), Body: hostname, port, username, password
