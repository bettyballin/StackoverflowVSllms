CREATE TABLE node (\n  id INT NOT NULL AUTO_INCREMENT,\n  name TEXT,\n  PRIMARY KEY (id)\n);\n\nCREATE TABLE edge (\n  from_node INT NOT NULL,\n  to_node INT NOT NULL,\n  weight FLOAT,\n  PRIMARY KEY (from_node, to_node),\n  FOREIGN KEY (from_node) REFERENCES node(id),\n  FOREIGN KEY (to_node) REFERENCES node(id)\n);