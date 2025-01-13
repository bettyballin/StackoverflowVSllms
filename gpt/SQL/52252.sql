CREATE TABLE Users (\n    UserID INT AUTO_INCREMENT PRIMARY KEY,\n    UserName VARCHAR(255) NOT NULL,\n    -- Other user-related fields\n);\n\nCREATE TABLE Postings (\n    PostID INT AUTO_INCREMENT PRIMARY KEY,\n    PostTitle VARCHAR(255) NOT NULL,\n    PostDescription TEXT,\n    -- Other posting-related fields\n);\n\nCREATE TABLE UserPostings (\n    UserID INT,\n    PostID INT,\n    FOREIGN KEY (UserID) REFERENCES Users(UserID),\n    FOREIGN KEY (PostID) REFERENCES Postings(PostID),\n    PRIMARY KEY (UserID, PostID)\n);