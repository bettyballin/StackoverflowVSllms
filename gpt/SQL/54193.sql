CREATE TABLE Users (\n    userId INT PRIMARY KEY AUTO_INCREMENT,\n    firstName VARCHAR(50),\n    lastName VARCHAR(50),\n    email VARCHAR(255) UNIQUE,\n    password VARCHAR(255)\n);