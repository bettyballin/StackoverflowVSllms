-- Creating a simple Users table\nCREATE TABLE Users (\n    UserID INT PRIMARY KEY AUTO_INCREMENT,\n    Username VARCHAR(255) NOT NULL UNIQUE,\n    Email VARCHAR(255) NOT NULL UNIQUE\n);\n\n-- Creating another table Orders with foreign key relation to Users\nCREATE TABLE Orders (\n    OrderID INT PRIMARY KEY AUTO_INCREMENT,\n    UserID INT,\n    OrderDate DATE,\n    FOREIGN KEY (UserID) REFERENCES Users(UserID)\n);