CREATE TABLE SomeIntersection \n(\n    TableAId UNIQUEIDENTIFIER REFERENCES TableA NOT NULL,\n    TableBId UNIQUEIDENTIFIER REFERENCES TableB NOT NULL,\n    PRIMARY KEY(TableAId, TableBId)\n);