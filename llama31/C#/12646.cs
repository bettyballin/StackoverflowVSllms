public partial class MyEntity\n{\n    partial void OnLastModifiedChanged()\n    {\n        // Validate and update LastModified in the class\n        LastModified = DateTime.Now;\n    }\n}\n\n// In the database (SQL Server):\nCREATE TABLE MyTable\n(\n    Id INT PRIMARY KEY,\n    LastModified DATETIME NOT NULL DEFAULT GETDATE()\n);