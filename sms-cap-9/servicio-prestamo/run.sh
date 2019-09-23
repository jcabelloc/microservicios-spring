#!/bin/bash

echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! nc -z fintech-eurekaserver $EUREKASERVER_PORT; do sleep 3; done
echo ">>>>>>>>>>>> Eureka Server has started"


echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! nc -z fintech-configurationserver $CONFIGSERVER_PORT; do sleep 3; done
echo ">>>>>>>>>>>> Configuration Server has started"

echo "********************************************************"
echo "Waiting for the database server to start on port $DATABASESERVER_PORT"
echo "********************************************************"
while ! nc -z database $DATABASESERVER_PORT; do sleep 3; done
echo ">>>>>>>>>>>> Database Server has started"

echo "********************************************************"
echo "Waiting for the kafka server to start on port $KAFKASERVER_PORT"
echo "********************************************************"
while ! nc -z kafkaserver $KAFKASERVER_PORT; do sleep 10; done
echo ">>>>>>>>>>>> Kafka Server has started"

echo "********************************************************"
echo "Waiting for the REDIS server to start on port $REDIS_PORT"
echo "********************************************************"
while ! nc -z redis $REDIS_PORT; do sleep 10; done
echo ">>>>>>>>>>>> REDIS Server has started"

echo "********************************************************"
echo "Waiting for the ZIPKIN server to start on port $ZIPKIN_PORT"
echo "********************************************************"
while ! nc -z zipkin $ZIPKIN_PORT; do sleep 10; done
echo ">>>>>>>>>>>> ZIPKIN Server has started"

echo "********************************************************"
echo "Starting Service with Configuration Service :  $CONFIGSERVER_URI via Eureka :  $EUREKASERVER_URI ON PORT: $SERVER_PORT"
echo "Using Kafka Server: $KAFKASERVER_URI"
echo "Using ZK    Server: $ZKSERVER_URI"
echo "********************************************************"
java -Dserver.port=$SERVER_PORT 										\
	-Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI            \
	-Dspring.cloud.config.uri=$CONFIGSERVER_URI 						\
    -Dspring.cloud.stream.kafka.binder.zkNodes=$ZKSERVER_URI  		    \
    -Dspring.cloud.stream.kafka.binder.brokers=$KAFKASERVER_URI         \
    -Dspring.zipkin.baseUrl=$ZIPKIN_URI                                 \
	-Dspring.profiles.active=$PROFILE 									\
	-jar /usr/share/servicios/$jar
	