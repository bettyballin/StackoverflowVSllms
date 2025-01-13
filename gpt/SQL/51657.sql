-- Original table without the large column\nCREATE TABLE table1 (\n    id INTEGER PRIMARY KEY,\n    firstName VARCHAR(255),\n    lastName VARCHAR(255),\n    address VARCHAR(255)\n);\n\n-- New table to store the large column\nCREATE TABLE lifeStories (\n    id INTEGER PRIMARY KEY,\n    table1_id INTEGER,\n    lifeStory TEXT,\n    FOREIGN KEY (table1_id) REFERENCES table1(id)\n);\n\n-- Example of inserting data\nINSERT INTO table1 (id, firstName, lastName, address) VALUES (1, 'John', 'Doe', '123 Main St');\nINSERT INTO lifeStories (id, table1_id, lifeStory) VALUES (1, 1, 'John\'s life story...');