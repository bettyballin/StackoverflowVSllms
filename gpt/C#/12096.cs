using (var context = new YourDbContext())\n{\n    // SQL Server specific query to get the edition\n    var edition = context.Database.SqlQuery<string>("SELECT SERVERPROPERTY('Edition')").FirstOrDefault();\n\n    if (edition != null)\n    {\n        if (edition.Contains("Express"))\n        {\n            Console.WriteLine("SQL Server Express Edition detected");\n            // Handle the licensing logic for SQLExpress\n        }\n        else\n        {\n            Console.WriteLine($"SQL Server Edition detected: {edition}");\n            // Handle the licensing logic for other editions\n        }\n    }\n    else\n    {\n        Console.WriteLine("Unable to determine SQL Server Edition");\n    }\n}