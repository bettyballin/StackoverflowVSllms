Dim dbPath As String = "C:\path\to\your\database.accdb"\nDim isProtected As Boolean = IsDatabasePasswordProtected(dbPath)\nIf isProtected Then\n    Console.WriteLine("The database is password protected.")\nElse\n    Console.WriteLine("The database is not password protected.")\nEnd If