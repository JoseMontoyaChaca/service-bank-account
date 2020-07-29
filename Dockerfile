FROM openjdk:8
ADD /target/service-bank-account-0.0.1-SNAPSHOT.jar service-bank-account.jar 
EXPOSE 8072
CMD ["java","-jar","service-bank-account.jar"]  
