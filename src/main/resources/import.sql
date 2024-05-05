INSERT INTO ROLE (id,name) VALUES (1,'ROLE_USER');
INSERT INTO ROLE (id,name) VALUES (2,'ROLE_ADMIN');

INSERT INTO app_user(first_name, last_name, email, password, role_id) VALUES ('Pera','Peric', 'peraperic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1);
INSERT INTO app_user(first_name, last_name, email, password, role_id) VALUES ('Admin','Admin', 'admin@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 2);
--password je "password123"

-- Insert Arrangement data

INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 1', 0, 100.0, 6.5, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 2', 1, 1000.0, 1.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 3', 1, 400.0, 3.0, '2023-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 4', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 5', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 6', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 7', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 8', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 9', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 10', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 11', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 12', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 13', 1, 400.0, 2.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 14', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended) VALUES ('Arrangement 15', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE);

INSERT INTO excursion (arrangement_id, name, price, type) VALUES (1, 'Excursion 1', 100.0, 3);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (1, 'Excursion 2', 120.0, 1);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (1, 'Excursion 3', 130.0, 0);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (2, 'Excursion 4', 200.0, 0);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (2, 'Excursion 5', 150.0, 2);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (2, 'Excursion 6', 180.0, 5);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 7', 100.0, 3);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 8', 4000.0, 4);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 9', 2500.0, 0);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 10', 600.0, 3);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 11', 750.0, 4);

INSERT INTO rating (arrangement_id, rating_value) VALUES (1, 4.8);
INSERT INTO rating (arrangement_id, rating_value) VALUES (1, 4.6);
INSERT INTO rating (arrangement_id, rating_value) VALUES (2, 4.2);