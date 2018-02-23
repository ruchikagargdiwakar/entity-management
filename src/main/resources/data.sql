insert into entity_item(id,name,description) values (1001,'PatientA','Healthcare Item');
insert into entity_item(id,name,description) values (1002,'BagA','Retail Item');
insert into entity_item(id,name,description) values (1003,'DoctorA','Healthcare Item');

insert into product(id,cost,product_category) values (1002,'5000','Bags');
insert into patient(id,address) values (1001,'AddressA');
insert into doctor(id,hospital_name) values (1003,'Apollo');
insert into patient_doctor(patient_id,doctor_id) values (1001,1003);