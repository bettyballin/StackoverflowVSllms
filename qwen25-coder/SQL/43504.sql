-- Station table definition\nCREATE TABLE StationTbl (\n    StnCode CHAR(10) PRIMARY KEY,\n    StnName VARCHAR(100),\n    StnCity VARCHAR(50)\n);\n\n-- Train table definition\nCREATE TABLE TrainTbl (\n    TrnNumber varchar(20) PRIMARY KEY,  -- Use a suitable length for the train number\n    TrnName VARCHAR(100)\n);\n\n-- TrainHopTable definition with composite key\nCREATE TABLE TrainHopTbl (\n    TrnNumber VARCHAR(20),\n    StationCode CHAR(10),\n    ArrTime TIME,\n    DepTime TIME,\n    HopIndex INT,\n    PRIMARY KEY (TrnNumber, StationCode, HopIndex),  -- Composite Key\n    FOREIGN KEY (StationCode) REFERENCES StationTbl(StnCode),\n    FOREIGN KEY (TrnNumber) REFERENCES TrainTbl(TrnNumber)\n);