-- Create table script\nCREATE TABLE [dbo].[YourTable]\n(\n    [Id] INT PRIMARY KEY,\n    [Name] NVARCHAR(50) NOT NULL\n);\n\n-- Insert data script\nINSERT INTO [dbo].[YourTable] (Id, Name)\nVALUES (1, 'John Doe'), (2, 'Jane Doe');