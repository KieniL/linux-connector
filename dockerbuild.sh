mvn -f ./backend/authservice/pom.xml compile jib:dockerBuild
mvn -f ./backend/connectorservice/pom.xml compile jib:dockerBuild
mvn -f ./backend/apiservice/pom.xml compile jib:dockerBuild
