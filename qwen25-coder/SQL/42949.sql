CREATE TABLE ReportingHierarchy (\n    RecordID INT PRIMARY KEY,\n    ParentID INT,\n    LevelID INT,\n    Name VARCHAR(255),\n    DataField DECIMAL(18, 2) -- Or any other data type suitable for your application\n);