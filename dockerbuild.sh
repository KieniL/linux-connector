mvn -f ./backend/authservice/pom.xml compile jib:dockerBuild -Dimage=authservice
mvn -f ./backend/connectorservice/pom.xml compile jib:dockerBuild -Dimage=connectorservice
mvn -f ./backend/apiservice/pom.xml compile jib:dockerBuild -Dimage=apiservice

docker build -t frontend:1.00 ./frontend
