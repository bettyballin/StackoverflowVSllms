CREATE VIEW students_city AS\nSELECT * FROM students\nWHERE city_id = (SELECT city_id FROM users WHERE id = CURRENT_USER_ID);\n\nCREATE VIEW students_national AS\nSELECT * FROM students\nWHERE country_id = (SELECT country_id FROM cities WHERE id = (SELECT city_id FROM users WHERE id = CURRENT_USER_ID));