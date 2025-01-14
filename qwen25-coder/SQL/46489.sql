CREATE TABLE Users (\n    UserID INT PRIMARY KEY,\n    Username VARCHAR(50),\n    PasswordHash VARCHAR(256)\n);\n\nCREATE TABLE UserProfiles (\n    ProfileID INT PRIMARY KEY,\n    UserID INT UNIQUE, -- ensures 1:1 relationship\n    Bio TEXT,\n    Preferences JSON,\n    FOREIGN KEY (UserID) REFERENCES Users(UserID)\n);