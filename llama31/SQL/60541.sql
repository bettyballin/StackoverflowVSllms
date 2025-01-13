CREATE TABLE UserRole (\n    UserRoleID INT IDENTITY(1,1) PRIMARY KEY,\n    UserID INT NOT NULL,\n    RoleID INT NOT NULL,\n    FOREIGN KEY (UserID) REFERENCES Users(UserID),\n    FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)\n);