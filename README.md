Note: used H2 db
Client for H2 db: http://localhost:8080/h2-console
 
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:

SELECT * FROM ENTITY_ITEM;
SELECT * FROM PRODUCT;
SELECT * FROM PATIENT;
SELECT * FROM DOCTOR; 
SELECT * FROM PATIENT_DOCTOR;	
    
1. Get entity specific to id:
url--> localhost:8080/entities/1001
request type --> GET

2. Get all entities:
url--> localhost:8080/entities
request type --> GET

2. Create product:
url--> localhost:8080/entities/product
request body--> {"name":"ProductDressA", "description":"This is dress", "cost":"1200", "productCategory":"Clothing"}
request type --> POST

3. Create patient (and mapped doctor):
url--> localhost:8080/entities/patient
request body--> 
{
  "name": "PatientB",
  "description": "Healthcare Item",
  "doctors": [
    {
      "name": "DoctorB",
      "description": "Healthcare Item",
      "hospitalName": "Manipal"
    }
  ],
  "address": "AddressB"
}
request type --> POST

4. Update product:
url--> localhost:8080/entities/product/1004
request body--> {"name":"ProductDressA_Updated","description":"This is dress", "cost":"1200", "productCategory":"Clothing"}
request type --> PUT

5. Delete entity:
url--> localhost:8080/entities/1002
request type --> DELETE

6. Update patient (partially working):
url--> localhost:8080/entities/patient/1005
request body-->   
{
  "name": "PatientB_Updated",
  "description": "Healthcare Item",
  "doctors": [
    {
     "name": "DoctorB",
      "description": "Healthcare Item",
      "hospitalName": "Manipal"
    }
  ],
  "address": "AddressB"
}
request type --> PUT