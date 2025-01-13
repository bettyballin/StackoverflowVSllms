CREATE TABLE Users (\n  id INT PRIMARY KEY,\n  username VARCHAR(255) NOT NULL,\n  email VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE Objects (\n  id INT PRIMARY KEY,\n  name VARCHAR(255) NOT NULL,\n  description TEXT\n);\n\nCREATE TABLE Features (\n  id INT PRIMARY KEY,\n  name VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE Ratings (\n  id INT PRIMARY KEY,\n  user_id INT NOT NULL,\n  object_id INT NOT NULL,\n  feature_id INT NOT NULL,\n  rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),\n  FOREIGN KEY (user_id) REFERENCES Users(id),\n  FOREIGN KEY (object_id) REFERENCES Objects(id),\n  FOREIGN KEY (feature_id) REFERENCES Features(id),\n  UNIQUE (user_id, object_id, feature_id)\n);