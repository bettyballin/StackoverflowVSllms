Imports System.IO\n\nModule Module1\n    Sub Main()\n        Dim filePath As String = "C:\yourdatabase.accdb"\n        Dim fileInfo As New FileInfo(filePath)\n        \n        Dim lastModified As DateTime = fileInfo.LastWriteTime\n        Dim lastAccessed As DateTime = fileInfo.LastAccessTime\n        \n        Console.WriteLine($"Last Modified Date: {lastModified}")\n        Console.WriteLine($"Last Accessed Date: {lastAccessed}")\n    End Sub\nEnd Module