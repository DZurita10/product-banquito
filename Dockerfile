FROM eclipse-temurin:17-jdk-focal

COPY product/target/product-0.0.1-SNAPSHOT.jar product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/product-0.0.1-SNAPSHOT.jar"]
EXPOSE 79
