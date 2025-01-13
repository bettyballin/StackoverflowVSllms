using System;\nusing System.Diagnostics;\n\nclass AttachToSqlServer\n{\n    static void Main(string[] args)\n    {\n        string sqlServerProcessName = "sqlservr.exe";\n        Process sqlServerProcess = Process.GetProcessesByName(sqlServerProcessName).FirstOrDefault();\n\n        if (sqlServerProcess != null)\n        {\n            Debugger.Attach(sqlServerProcess);\n            Console.WriteLine("Attached to SQL Server process.");\n        }\n        else\n        {\n            Console.WriteLine("SQL Server process not found.");\n        }\n    }\n}