CREATE TABLE User (\n        UserID INT PRIMARY KEY,\n        UserName VARCHAR(50) NOT NULL\n    );\n\n    CREATE TABLE UserCredentials (\n        UserID INT PRIMARY KEY,\n        PasswordHash VARCHAR(255) NOT NULL,\n        Salt VARCHAR(255) NOT NULL,\n        FOREIGN KEY (UserID) REFERENCES User(UserID)\n    );