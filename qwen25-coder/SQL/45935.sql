CREATE TABLE Films (\n       filmid INT AUTO_INCREMENT PRIMARY KEY,\n       filmtitle VARCHAR(255) NOT NULL,\n       runningtime INT,  -- in minutes\n       description TEXT,\n       year YEAR,\n       director_id INT,\n       genre_id INT,\n       FOREIGN KEY (director_id) REFERENCES Directors(directorid),\n       FOREIGN KEY (genre_id) REFERENCES Genres(genreid)\n     );