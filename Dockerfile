FROM openjdk:8
MAINTAINER Salman  Salman.Patel@iiitb.org
COPY ./target/CalculatorUsingDevops-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-cp", "CalculatorUsingDevops-1.0-SNAPSHOT-jar-with-dependencies.jar", "calculator.calculator"]
#SALMAN