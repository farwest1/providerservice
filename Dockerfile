# FROM airhacks/payara
FROM jboss/wildfly
#FROM openjdk:alpine
#COPY ./target/loadb.war ${DEPLOYMENT_DIR}
ADD ./target/providerservice.war /opt/jboss/wildfly/standalone/deployments/
#COPY ./target/loadb-swarm.jar /usr/lib/myapp/
EXPOSE 8080 8443 9990
MAINTAINER Bernd Moeller <moeller-bernd@gmx.de>
#WORKDIR /usr/lib/myapp

RUN /opt/jboss/wildfly/bin/add-user.sh admin ZR20010$%! --silent
#CMD ["java", "-jar", "loadb-swarm.jar"]
