-- Create user-defined Table Type\nCREATE TYPE dbo.ContactDetails AS TABLE \n(\n    ContactName NVARCHAR(100),\n    Designation NVARCHAR(100)\n);\nGO