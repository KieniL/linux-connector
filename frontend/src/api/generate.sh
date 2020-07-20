#!/bin/bash
if [ ! -f openapi-generator-cli.jar ]; then
    curl https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/3.3.4/openapi-generator-cli-3.3.4.jar --output openapi-generator-cli.jar
fi

cd "$(dirname "$0")"
mkdir temp && cd temp

git clone https://github.com/KieniL/linux-connector.git
java -jar ./../openapi-generator-cli.jar generate -i  ./linux-connector/apiservice/openapi/auth-api.yml -g typescript-axios -o ./../authentication
java -jar ./../openapi-generator-cli.jar generate -i  ./linux-connector/apiservice/openapi/connector-api.yml -g typescript-axios -o ./../connection
java -jar ./../openapi-generator-cli.jar generate -i  ./linux-connector/apiservice/openapi/connectionstore-api.yml -g typescript-axios -o ./../connectionstore

cd .. && rm -rf temp