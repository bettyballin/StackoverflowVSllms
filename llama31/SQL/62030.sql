CREATE TABLE example (name TEXT COLLATE NOCASE);\nINSERT INTO example (name) VALUES ('A'), ('a'), ('ä');\n\nSELECT * FROM example ORDER BY name;