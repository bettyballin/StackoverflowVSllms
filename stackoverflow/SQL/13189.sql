DECLARE @Object_Table TABLE\n(\n    Id INT NOT NULL PRIMARY KEY\n)\n\nDECLARE @Link_Table TABLE\n(\n    ObjectId INT NOT NULL,\n    DataId INT NOT NULL\n)\n\nDECLARE @Data_Table TABLE\n(\n    Id INT NOT NULL Identity(1,1),\n    Data VARCHAR(50) NOT NULL\n)\n\n-- create two objects '1' and '2'\nINSERT INTO @Object_Table (Id) VALUES (1)\nINSERT INTO @Object_Table (Id) VALUES (2)\n\n-- create some data\nINSERT INTO @Data_Table (Data) VALUES ('Data One')\nINSERT INTO @Data_Table (Data) VALUES ('Data Two')\n\n-- link all data to first object\nINSERT INTO @Link_Table (ObjectId, DataId)\nSELECT Objects.Id, Data.Id\nFROM @Object_Table AS Objects, @Data_Table AS Data\nWHERE Objects.Id = 1