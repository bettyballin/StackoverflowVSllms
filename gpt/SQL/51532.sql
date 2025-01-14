-- Creating a table with varchar column\nCREATE TABLE Logs (\n    LogID INT PRIMARY KEY,\n    LogData NVARCHAR(MAX)\n);\n\n-- Inserting XML data\nINSERT INTO Logs (LogID, LogData)\nVALUES (1, N'<SOAPMessage><Header>...</Header><Body>...</Body></SOAPMessage>');\n\n-- Querying XML data (would require parsing the string)\n-- This example uses CHARINDEX and SUBSTRING, but it would be more complex to handle\nSELECT SUBSTRING(LogData, CHARINDEX('<Body>', LogData), CHARINDEX('</Body>', LogData) - CHARINDEX('<Body>', LogData) + 7)\nFROM Logs\nWHERE LogID = 1;