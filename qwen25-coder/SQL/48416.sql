CREATE TABLE notes (\n    id INT PRIMARY KEY,\n    title VARCHAR(255)\n);\n\nCREATE TABLE labels (\n    id INT PRIMARY KEY,\n    name VARCHAR(255)\n);\n\nCREATE TABLE note_labels (\n    note_id INT,\n    label_id INT,\n    FOREIGN KEY (note_id) REFERENCES notes(id),\n    FOREIGN KEY (label_id) REFERENCES labels(id)\n);