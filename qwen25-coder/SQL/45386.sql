-- Adding a new datetime column if rowversion wasn't serving the correct purpose\nALTER TABLE YourTableName ADD CreatedDateTime DATETIME DEFAULT GETDATE();\n\n-- Populate it with the current datetime for existing records\nUPDATE YourTableName SET CreatedDateTime = GETDATE();\n\n-- Optionally, drop the rowversion column if it's no longer needed\nALTER TABLE YourTableName DROP COLUMN RowVersionColumn;