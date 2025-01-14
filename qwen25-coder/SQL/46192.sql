CREATE TABLE Users (\n    User_ID INT AUTO_INCREMENT PRIMARY KEY,  -- Using INT for scalability in small to medium size applications\n    Username VARCHAR(50) NOT NULL UNIQUE,\n    Email VARCHAR(100) NOT NULL UNIQUE\n);