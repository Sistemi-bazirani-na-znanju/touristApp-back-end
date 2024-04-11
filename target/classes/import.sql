INSERT INTO ROLE (id,name) VALUES (1,'ROLE_USER');
INSERT INTO ROLE (id,name) VALUES (2,'ROLE_ADMIN');

INSERT INTO app_user(first_name, last_name, email, password, role_id) VALUES ('Pera','Peric', 'peraperic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1);
--password je "password123"

-- Insert Arrangement data

INSERT INTO arrangement (name, type, price, average_rating, date) VALUES ('Arrangement 1', 0, 100.0, 4.5, '2023-01-01T00:00:00');
INSERT INTO arrangement (name, type, price, average_rating, date) VALUES ('Arrangement 2', 0, 1000.0, 4.0, '2023-01-01T00:00:00');
INSERT INTO arrangement (name, type, price, average_rating, date) VALUES ('Arrangement 3', 0, 200.0, 4.2, '2023-01-01T00:00:00');

-- Insert Excursion data
-- Please note that you need to specify arrangement_id based on your existing Arrangement data
INSERT INTO excursion (arrangement_id, name, price, number_of_people_registered, type, total_price) VALUES (1, 'Excursion 1', 50.0, 20, 0, 1000.0);
INSERT INTO excursion (arrangement_id, name, price, number_of_people_registered, type, total_price) VALUES (1, 'Excursion 2', 60.0, 25, 1, 1200.0);
INSERT INTO excursion (arrangement_id, name, price, number_of_people_registered, type, total_price) VALUES (2, 'Excursion 3', 1000.0, 30, 0, 1400.0);

-- Insert Rating data
-- Please note that you need to specify arrangement_id based on your existing Arrangement data
INSERT INTO rating (arrangement_id, rating_value) VALUES (1, 4.8);
INSERT INTO rating (arrangement_id, rating_value) VALUES (1, 4.6);
INSERT INTO rating (arrangement_id, rating_value) VALUES (2, 4.2);