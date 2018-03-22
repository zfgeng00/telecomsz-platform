FROM openjdk:8

MAINTAINER WangJin

COPY target/telecomsz-platform-latest.jar /usr/local/bin/

EXPOSE 9005 9000

CMD ["java","-jar","/usr/local/bin/telecomsz-platform-latest.jar","--spring.profiles.active=dist"]

