-- Insert demo_model data
INSERT INTO demo_model(name) VALUES ('Prvi');
INSERT INTO demo_model(name) VALUES ('Drugi');

-- Insert Arrangement data
INSERT INTO arrangement (name, type, price, average_rating) VALUES ('Arrangement 1', 0, 100.0, 4.5);
INSERT INTO arrangement (name, type, price, average_rating) VALUES ('Arrangement 2', 0, 150.0, 4.0);
INSERT INTO arrangement (name, type, price, average_rating) VALUES ('Arrangement 3', 0, 200.0, 4.2);

-- Insert Excursion data
-- Please note that you need to specify arrangement_id based on your existing Arrangement data
INSERT INTO excursion (arrangement_id, name, price, number_of_people_registered, type, total_price) VALUES (1, 'Excursion 1', 50.0, 20, 0, 1000.0);
INSERT INTO excursion (arrangement_id, name, price, number_of_people_registered, type, total_price) VALUES (1, 'Excursion 2', 60.0, 25, 1, 1200.0);
INSERT INTO excursion (arrangement_id, name, price, number_of_people_registered, type, total_price) VALUES (2, 'Excursion 3', 70.0, 30, 2, 1400.0);

-- Insert Rating data
-- Please note that you need to specify arrangement_id based on your existing Arrangement data
INSERT INTO rating (arrangement_id, rating_value) VALUES (1, 4.8);
INSERT INTO rating (arrangement_id, rating_value) VALUES (1, 4.6);
INSERT INTO rating (arrangement_id, rating_value) VALUES (2, 4.2);
