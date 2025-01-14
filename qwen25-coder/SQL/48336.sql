USE YourDatabaseName;\nGO\n\n-- Create a sample table structure\nCREATE TABLE SampleData (\n    ID INT PRIMARY KEY,\n    Name NVARCHAR(100),\n    Age INT,\n    Email NVARCHAR(255)\n);\nGO\n\n-- Generate large amounts of test data\nDECLARE @i INT = 1, @Max INT = 10000;\n\nWHILE (@i <= @Max) \nBEGIN\n    INSERT INTO SampleData (ID, Name, Age, Email)\n    VALUES (\n        @i,\n        'Name' + CAST(@i AS NVARCHAR(10)),\n        ABS(CHECKSUM(NEWID()) % 120) + 20, -- Random age between 20 and 140\n        'email' + CAST(@i AS NVARCHAR(10)) + '@example.com'\n    );\n    \n    SET @i += 1;\nEND;\n\nGO