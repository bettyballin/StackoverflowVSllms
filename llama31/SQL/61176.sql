CREATE TABLE categories (\n  id INT PRIMARY KEY,\n  name VARCHAR(50),\n  parent_id INT\n);\n\nCREATE TABLE videos (\n  id INT PRIMARY KEY,\n  title VARCHAR(100)\n);\n\nCREATE TABLE video_categories (\n  video_id INT,\n  category_id INT,\n  PRIMARY KEY (video_id, category_id),\n  FOREIGN KEY (video_id) REFERENCES videos(id),\n  FOREIGN KEY (category_id) REFERENCES categories(id)\n);