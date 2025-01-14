CREATE TABLE Users (\n    User_ID INT AUTO_INCREMENT PRIMARY KEY,\n    User_Name VARCHAR(255) NOT NULL,\n    Email VARCHAR(255) UNIQUE NOT NULL,\n    Password_Hash VARCHAR(255) NOT NULL\n);\n\nCREATE TABLE Items (\n    Item_ID INT AUTO_INCREMENT PRIMARY KEY,\n    User_ID INT,\n    Item_Details TEXT,\n    FOREIGN KEY (User_ID) REFERENCES Users(User_ID)\n        ON DELETE CASCADE\n);\n\nCREATE TABLE Pictures (\n    Picture_ID INT AUTO_INCREMENT PRIMARY KEY,\n    Item_ID INT,\n    Picture_URL VARCHAR(255),\n    FOREIGN KEY (Item_ID) REFERENCES Items(Item_ID)\n        ON DELETE CASCADE\n);