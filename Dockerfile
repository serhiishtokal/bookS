
FROM openjdk:11
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /home/app/pom.xml
COPY src /home/app/src
RUN mvn -f /home/app/pom.xml clean package
ENTRYPOINT ["java", "-jar", "home/app/target/simpleapp-1.0.0.jar"]