INSERT INTO ROLE (id,name) VALUES (1,'ROLE_USER');
INSERT INTO ROLE (id,name) VALUES (2,'ROLE_ADMIN');

INSERT INTO app_user (first_name, last_name, email, password, role_id, new)VALUES ('Pera', 'Peric', 'peraperic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE);
--password je "password123"

INSERT INTO app_user (first_name, last_name, email, password, role_id, new)VALUES ('Marko', 'Markovic', 'marko.markovic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE); 
--password for Marko is "password123"

INSERT INTO app_user (first_name, last_name, email, password, role_id, new)VALUES ('Ana', 'Anic', 'ana.anic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE); 

INSERT INTO app_user (first_name, last_name, email, password, role_id, new)VALUES ('Zoki', 'Zanic', 'zoki.anic@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE); 
--password for Ana is "password123"

INSERT INTO app_user (first_name, last_name, email, password, role_id, new)VALUES ('Zika', 'Zikic', 'zika@gmail.com', '$2a$10$nrCPz3vEZvmjlPeNbt4RQ.bSIngRXMlwMxfJJtp1Bhn.f0op9Zcui', 1, TRUE);

-- Insert destinations
-- Insert destinations
INSERT INTO destination (destination_name) VALUES ('Paris');
INSERT INTO destination (destination_name) VALUES ('London');
INSERT INTO destination (destination_name) VALUES ('New York');
INSERT INTO destination (destination_name) VALUES ('Tokyo');
INSERT INTO destination (destination_name) VALUES ('Sydney');
INSERT INTO destination (destination_name) VALUES ('Rome');
INSERT INTO destination (destination_name) VALUES ('Barcelona');
INSERT INTO destination (destination_name) VALUES ('Los Angeles');
INSERT INTO destination (destination_name) VALUES ('Hong Kong');
INSERT INTO destination (destination_name) VALUES ('Singapore');
INSERT INTO destination (destination_name) VALUES ('Dubai');
INSERT INTO destination (destination_name) VALUES ('Cape Town');


-- Insert excursion types
INSERT INTO excursion_type_class (excursion_type) VALUES (0);
INSERT INTO excursion_type_class (excursion_type) VALUES (1);
INSERT INTO excursion_type_class (excursion_type) VALUES (2);
INSERT INTO excursion_type_class (excursion_type) VALUES (3);
INSERT INTO excursion_type_class (excursion_type) VALUES (4);
INSERT INTO excursion_type_class (excursion_type) VALUES (5);
INSERT INTO excursion_type_class (excursion_type) VALUES (6);



INSERT INTO user_destinations (user_id, destination_id) VALUES (1, 1); -- Pera Peric, Paris
INSERT INTO user_destinations (user_id, destination_id) VALUES (1, 2); -- Pera Peric, London
INSERT INTO user_destinations (user_id, destination_id) VALUES (1, 3); -- Pera Peric, Tokyo

INSERT INTO user_destinations (user_id, destination_id) VALUES (2, 1); -- Pera Peric, Paris
INSERT INTO user_destinations (user_id, destination_id) VALUES (2, 2); -- Pera Peric, London
INSERT INTO user_destinations (user_id, destination_id) VALUES (2, 3); -- Pera Peric, Tokyo

INSERT INTO user_destinations (user_id, destination_id) VALUES (2, 1); -- Pera Peric, Paris
INSERT INTO user_destinations (user_id, destination_id) VALUES (2, 2); -- Pera Peric, London
INSERT INTO user_destinations (user_id, destination_id) VALUES (2, 3); -- Pera Peric, Tokyo

-- Insert data into the user_excursion_types table
INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (1, 1); -- Pera Peric, Excursion type 0
INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (1, 2); -- Pera Peric, Excursion type 1
INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (1, 3); -- Pera Peric, Excursion type 2

INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (2, 1); -- Pera Peric, Excursion type 0
INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (2, 2); -- Pera Peric, Excursion type 1
INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (2, 3); -- Pera Peric, Excursion type 2

INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (3, 1); -- Pera Peric, Excursion type 0
INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (3, 2); -- Pera Peric, Excursion type 1
INSERT INTO user_excursion_types (user_id, excursion_type_id) VALUES (3, 3); -- Pera Peric, Excursion type 2

-- Insert Arrangement data

INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 2', 1, 1000.0, 1.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 3', 1, 400.0, 3.0, '2023-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 2);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 4', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 3);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 5', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 4);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 6', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 5);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 7', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 6);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 8', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 6);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 9', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 6);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 10', 1, 400.0, 4.0, '2024-04-03T00:00:00', FALSE, FALSE, FALSE, 0, 6);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 11', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 6);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 12', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 6);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 13', 1, 400.0, 2.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 6);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 14', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 15', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 16', 1, 1000.0, 1.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 17', 1, 400.0, 3.0, '2023-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 18', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 19', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 20', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 21', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 22', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 23', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 24', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 25', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 26', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 27', 1, 400.0, 2.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 28', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 29', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 30', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);
INSERT INTO arrangement (name, type, price, average_rating, date, is_new, is_popular, is_recommended, recommendation_points, destination_id) VALUES ('Arrangement 31', 1, 400.0, 4.0, '2024-03-03T00:00:00', FALSE, FALSE, FALSE, 0, 1);



INSERT INTO excursion (arrangement_id, name, price, type) VALUES (1, 'Excursion 1', 100.0, 3);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (1, 'Excursion 2', 120.0, 1);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (1, 'Excursion 3', 130.0, 0);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (2, 'Excursion 4', 200.0, 0);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (2, 'Excursion 5', 150.0, 5);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (2, 'Excursion 6', 180.0, 5);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 7', 100.0, 3);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 8', 4000.0, 4);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 9', 2500.0, 0);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 10', 600.0, 3);
INSERT INTO excursion (arrangement_id, name, price, type) VALUES (3, 'Excursion 11', 750.0, 4);

INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (1, 4.8, 1);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (2, 4.6, 1);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (3, 4.2, 1);

INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (1, 4.5, 2); -- Marko rates arrangement 1
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (2, 4.7, 2); -- Marko rates arrangement 2
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (3, 3.9, 2); -- Marko rates arrangement 3

INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (7, 5.0, 1); -- Ana rates arrangement 1
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (7, 4.1, 2); -- Ana rates arrangement 3
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (7, 4.8, 3); -- Ana rates arrangement 4
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (7, 4.8, 4);

INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (8, 1.8, 1);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (8, 1.6, 1);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (8, 1.2, 1);

INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (9, 4.8, 1);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (9, 4.6, 2);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (9, 4.2, 3);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (9, 4.8, 4);


INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (11, 4.8, 2);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (17, 4.6, 2);
INSERT INTO rating (arrangement_id, rating_value, user_id) VALUES (20, 4.2, 2);

INSERT INTO reservation (number_of_people, total_price, arrangement_id, user_id) VALUES (4,300,3,1)
INSERT INTO reservation (number_of_people, total_price, arrangement_id, user_id) VALUES (4,300,2,1)

