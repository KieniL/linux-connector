mvn -f ./authservice/pom.xml compile jib:dockerBuild
mvn -f ./connectorservice/pom.xml compile jib:dockerBuild
mvn -f ./apiservice/pom.xml compile jib:dockerBuild
