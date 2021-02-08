### Problem 1  
Spring Boot app implementing an API for a job application test  

#### Build  
```
./mvnw clean install
```

#### Run  
```
/mvnw spring-boot:run
```

#### Run with Docker (there is an image stored in Docker hub) 
 ```
 docker pull anikies/embl-fire-test:1.0
 docker run -d -p 80:8080 -t anikies/embl-fire-test:1.0
 ```  

#### API documentation   
  http://localhost:8080/emblfire/swagger-ui.html

#### Postman collection
  EMBL_FIRE_TEST.postman_collection.json
