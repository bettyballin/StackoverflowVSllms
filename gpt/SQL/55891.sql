CREATE TABLE FOO_Fruits (\n       foo_id INT,\n       fruit_id INT,\n       PRIMARY KEY (foo_id, fruit_id),\n       FOREIGN KEY (foo_id) REFERENCES FOO(id),\n       FOREIGN KEY (fruit_id) REFERENCES Fruits(id)\n   );