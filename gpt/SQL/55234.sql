CREATE TABLE ShortTextTable (\n    ID bigint IDENTITY(1,1) NOT NULL,\n    TextValue nvarchar(200),\n    PRIMARY KEY (ID)\n);\n\nCREATE TABLE LongTextTable (\n    ID bigint IDENTITY(1,1) NOT NULL,\n    TextValue nvarchar(4000),\n    PRIMARY KEY (ID)\n);