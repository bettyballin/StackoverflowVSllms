CREATE TABLE ArtistFans (\n    ArtistFanID INT AUTO_INCREMENT PRIMARY KEY,\n    ArtistID INT,\n    UserID INT,\n    UNIQUE (ArtistID, UserID),\n    FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID),\n    FOREIGN KEY (UserID) REFERENCES Users(UserID)\n);