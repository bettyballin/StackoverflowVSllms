Imports System.IO\n\nModule Module1\n    Sub Main()\n        Dim filePath As String = "C:\path\to\your\app.exe"\n\n        If IsFileInUse(filePath) Then\n            Console.WriteLine("File is in use.")\n        Else\n            Console.WriteLine("File is not in use.")\n        End If\n    End Sub\n\n    Function IsFileInUse(filePath As String) As Boolean\n        Try\n            Using fs As New FileStream(filePath, FileMode.Open, FileAccess.Read, FileShare.None)\n                ' If we can open the file exclusively, it is not in use\n                fs.Close()\n            End Using\n            Return False\n        Catch ex As IOException\n            ' If an IOException is thrown, the file is in use\n            Return True\n        End Try\n    End Function\nEnd Module