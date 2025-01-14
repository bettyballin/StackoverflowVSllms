-- Add a column to store the insertion timestamp\nALTER TABLE YourTableName\nADD InsertionTime DATETIME DEFAULT GETDATE();\n\n-- Ensure the column is populated with the current date and time for existing rows\nUPDATE YourTableName\nSET InsertionTime = GETDATE()\nWHERE InsertionTime IS NULL;\n\n-- (Optional) Set a default constraint so that future inserts automatically have the timestamp\nALTER TABLE YourTableName\nADD CONSTRAINT DF_InsertionTime DEFAULT GETDATE() FOR InsertionTime;