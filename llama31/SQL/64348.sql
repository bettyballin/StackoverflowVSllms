CREATE TABLE example (id SERIAL PRIMARY KEY, values INTEGER[]);\nINSERT INTO example (values) VALUES (ARRAY[1, 2, 3]);\nSELECT * FROM example WHERE values @> ARRAY[2];