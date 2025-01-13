CREATE TABLE MovieMetadata (\n    MetadataID INT PRIMARY KEY,\n    MovieID INT,\n    Attribute VARCHAR(255),\n    Source VARCHAR(255),\n    Journalist VARCHAR(255),\n    FOREIGN KEY (MovieID) REFERENCES Movie(MovieID)\n);