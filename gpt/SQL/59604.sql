CREATE TABLE CalculationScripts (\n       Id INT PRIMARY KEY IDENTITY,\n       Name NVARCHAR(100),\n       Script NVARCHAR(MAX)\n   );\n\n   INSERT INTO CalculationScripts (Name, Script)\n   VALUES ('SumCalculation', 'SELECT SUM(value) FROM @numbers');