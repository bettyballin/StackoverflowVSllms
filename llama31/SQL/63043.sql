CREATE TABLE Role (\n  Actor INT NOT NULL,\n  Movie INT NOT NULL,\n  Character INT NOT NULL,\n  PRIMARY KEY (Actor, Movie, Character)\n);