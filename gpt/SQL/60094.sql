CREATE TABLE AuthorVersions (\n    VersionID INT PRIMARY KEY,\n    AuthorID INT,\n    Name NVARCHAR(255),\n    Bio TEXT,\n    Timestamp DATETIME,\n    FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID)\n);