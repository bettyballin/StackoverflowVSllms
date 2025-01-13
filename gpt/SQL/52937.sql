-- Script for creating table\nCREATE TABLE [dbo].[YourTable](\n    [ID] [int] IDENTITY(1,1) NOT NULL,\n    [Name] [nvarchar](50) NOT NULL,\n    [Value] [nvarchar](50) NULL,\n    PRIMARY KEY CLUSTERED ([ID] ASC)\n);\n\n-- Script for inserting data\nINSERT INTO [dbo].[YourTable] ([Name], [Value]) VALUES ('ExampleName1', 'ExampleValue1');\nINSERT INTO [dbo].[YourTable] ([Name], [Value]) VALUES ('ExampleName2', 'ExampleValue2');