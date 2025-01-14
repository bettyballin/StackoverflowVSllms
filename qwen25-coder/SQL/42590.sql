-- Hypothetical tables for demonstration\nCREATE TABLE OuterTable (\n    ID INT PRIMARY KEY,\n    Data NVARCHAR(100)\n);\n\nCREATE TABLE InnerTable (\n    MatchID INT FOREIGN KEY REFERENCES OuterTable(ID),\n    Value INT\n);\n\n-- Join that can lead to a nested loops execution plan\nSELECT o.ID, i.Value\nFROM OuterTable o\nJOIN InnerTable i ON o.ID = i.MatchID;