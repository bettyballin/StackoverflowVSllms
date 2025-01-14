Imports System.IO\n\nFunction IsFileLocked(file As FileInfo) As Boolean\n    Try\n        Using inputStream = file.Open(FileMode.Open, FileAccess.Read, FileShare.None)\n            'file is not locked\n            Return False\n        End Using\n    Catch ex As IOException\n        'the file is unavailable because it is:\n        'still being written to\n        'or being processed by another thread\n        'or does not exist (has already been processed)\n        Return True\n    End Try\nEnd Function\n\n' Usage\nDim fileInfo As New FileInfo("C:\path\to\file.txt")\nIf IsFileLocked(fileInfo) Then\n    Console.WriteLine("The file is locked.")\nElse\n    Console.WriteLine("The file is not locked.")\nEnd If