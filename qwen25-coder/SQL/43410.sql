CREATE TABLE example (\n    id SERIAL PRIMARY KEY,\n    name TEXT,\n    value REAL\n);\nINSERT INTO example (name, value) VALUES ('test', 1.0);\nSELECT * FROM example;