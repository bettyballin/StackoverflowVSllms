CREATE TABLE EventLog (\n    DeviceID NVARCHAR(50),\n    Value INT,\n    Timestamp DATETIME,\n    PRIMARY KEY (DeviceID, Timestamp)\n);