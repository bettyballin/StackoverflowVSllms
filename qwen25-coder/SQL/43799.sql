-- Change the collation of a specific column in table1\nALTER TABLE [dbo].[table1]\nALTER COLUMN [table1column1] NVARCHAR(255) COLLATE YourDesiredCollation;