CREATE TABLE [dbo].[Fact_Sales]\n(\n    [SalesKey] INT PRIMARY KEY,\n    [DateKey] INT,\n    [ProductKey] INT,\n    [SalesAmount] DECIMAL(10, 2)\n);