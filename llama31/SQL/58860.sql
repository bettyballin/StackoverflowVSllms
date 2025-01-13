CREATE TABLE Permissions (\n    PermissionId INT PRIMARY KEY,\n    PermissionName VARCHAR(50)\n);\n\nCREATE TABLE Roles (\n    RoleId INT PRIMARY KEY,\n    RoleName VARCHAR(50)\n);\n\nCREATE TABLE RolePermissions (\n    RoleId INT,\n    PermissionId INT,\n    PRIMARY KEY (RoleId, PermissionId),\n    FOREIGN KEY (RoleId) REFERENCES Roles(RoleId),\n    FOREIGN KEY (PermissionId) REFERENCES Permissions(PermissionId)\n);