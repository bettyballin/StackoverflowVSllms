Imports System.IO\n\nSub CreateFolderIfNotExists(folderPath As String)\n    Try\n        If Not Directory.Exists(folderPath) Then\n            Directory.CreateDirectory(folderPath)\n        End If\n    Catch ex As Exception\n        Console.WriteLine("An error occurred: " & ex.Message)\n    End Try\nEnd Sub