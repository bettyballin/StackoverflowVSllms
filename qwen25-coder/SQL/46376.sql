CREATE TABLE Colors (\n       Id INT PRIMARY KEY IDENTITY(1,1),\n       Name NVARCHAR(50) NOT NULL,\n       RGB HexValue -- or whatever type you are using to store RGB values\n   );