using System;\nusing Microsoft.Office.Interop.Access;\n\nclass RenameTablesInQueries\n{\n    public static void RenameTables(string filePath, string tableName, string newTableName)\n    {\n        // Open the Access database\n        Application app = new Application();\n        app.Visible = false;\n        app.OpenCurrentDatabase(filePath);\n\n        // Loop through all queries in the database\n        foreach (QueryDef query in app.CurrentDb().QueryDefs)\n        {\n            // Check if the query contains the table name\n            if (query.SQL.Contains(tableName))\n            {\n                // Replace the table name with the new one\n                query.SQL = query.SQL.Replace(tableName, newTableName);\n                // Save the changes\n                query.Close();\n            }\n        }\n\n        // Close the database\n        app.CloseCurrentDatabase();\n        app.Quit();\n    }\n\n    public static void Main(string[] args)\n    {\n        string filePath = @"C:\Path\To\Your\Database.accdb";\n        string tableName = "tableName";\n        string newTableName = "newTableName";\n\n        RenameTables(filePath, tableName, newTableName);\n    }\n}