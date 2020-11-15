# thrift

## Comands to run project

### Create java files
thrift --gen java chavevalor.thrift

### Compile java files
javac -cp jars/libthrift-0.13.0.jar:jars/slf4j-api-1.7.21.jar:jars/javax.annotation-api-1.3.2.jar:gen-java -d . *.java

### Start server
java -cp jars/libthrift-0.13.0.jar:jars/slf4j-api-1.7.21.jar:jars/javax.annotation-api-1.3.2.jar:gen-java:. chavevalor.ChaveValorServer

### Start client
java -cp jars/libthrift-0.13.0.jar:jars/slf4j-api-1.7.21.jar:jars/javax.annotation-api-1.3.2.jar:gen-java:. chavevalor.ChaveValorClient
