INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (1, 'Ron Swanson', 'ARh+', '92kg', '190cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (2, 'April Ludgate', 'BRh+', '54kg', '150cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (3, 'Leslie Knope', 'ABRh+', '57kg', '155cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (4, 'Andy Dwyer', 'ARh-', '97kg', '195cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (5, 'Ann Perkins', 'BRh-', '51kg', '160cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (6, 'Ben Wyatt', 'ABRh-', '67kg', '167cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (7, 'Jerry Gergich', '0Rh+', '110kg', '180cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (8, 'Tom Haverford', '0Rh-', '53kg', '170cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (9, 'Chris Traeger', 'ARh+', '78kg', '190cm');
INSERT INTO cs320.patient (patient_id, patient_name, blood_type, p_weight, p_height) VALUES (10, 'Donna Meagle', 'BRh+', '90kg', '185cm');




INSERT INTO cs320.doctor (doctor_id, doctor_name, d_field, d_bloodtype, d_weight, d_height) VALUES (1, 'Alperen AKYOL', 'cardiology', 'ARH+', '74kg', '176cm');
INSERT INTO cs320.doctor (doctor_id, doctor_name, d_field, d_bloodtype, d_weight, d_height) VALUES (2, 'Ayberk ORHON', 'general surgeon', 'ARh+', '85kg', '185cm');
INSERT INTO cs320.doctor (doctor_id, doctor_name, d_field, d_bloodtype, d_weight, d_height) VALUES (3, 'Maram ELSEBAKHİ', 'ophthalmologist', 'ARh+', '60kg', '175cm');
INSERT INTO cs320.doctor (doctor_id, doctor_name, d_field, d_bloodtype, d_weight, d_height) VALUES (4, 'Erhan ÇEKİN', 'general practitioner', 'ARh+', '80kg', '180cm');



#Maram-Patient
#Patient create appointment
#insert into Appointment values(
#patient_id,( select `doctor_id` from `cs320`.`doctor` where doctorname(`doctor_name`)),`ap_from`, `ap_to`) ;

#Patient cancel appointment if there is more than 1 day left
#delete from `cs320`.`appointment` where `patient_id`=`` and `ap_from` > date_add(now(), INTERVAL 1 day);
