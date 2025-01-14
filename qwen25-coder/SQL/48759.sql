CREATE TABLE Role_Permissions (\n        RoleID INT,\n        Permissions BIT(64), -- Assuming 64-bit for more flexibility\n        PRIMARY KEY (RoleID),\n        FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)\n    );