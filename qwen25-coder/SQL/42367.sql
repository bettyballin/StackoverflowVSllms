CREATE TABLE Fact_Roles (\n    RoleID INT,\n    DateKey INT,\n    OrganizationSK INT NOT NULL,\n    RoleTypeSK INT NOT NULL,\n    PersonSK INT NOT NULL,\n    RoleCount INT DEFAULT 1\n);