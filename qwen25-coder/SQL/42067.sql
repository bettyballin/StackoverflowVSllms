-- Create a temporary table to hold the parsed names\nCREATE TABLE #ParsedNames (\n    Name NVARCHAR(255),\n    FirstName NVARCHAR(100),\n    MiddleName NVARCHAR(100),\n    LastName NVARCHAR(100),\n    Suffix NVARCHAR(50)\n)\n\n-- Insert data into the temporary table by invoking your function for each name\nINSERT INTO #ParsedNames (Name, FirstName, MiddleName, LastName, Suffix)\nSELECT \n    a.Name,\n    b.FirstName,\n    b.MiddleName,\n    b.LastName,\n    b.Suffix\nFROM employees a, (\n    SELECT * FROM dbo.parseName(a.name)\n) b\n\n-- Now insert into the target table from the temporary table\nINSERT INTO blah (Name, firstName, middleName, lastName, suffix)\nSELECT Name, FirstName, MiddleName, LastName, Suffix FROM #ParsedNames\n\n-- Clean up the temporary table\nDROP TABLE #ParsedNames