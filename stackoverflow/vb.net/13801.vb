Imports System.Drawing\nModule Module1\n\n    Sub Main()    \n        Dim filePath As String =  "C:\myfile.exe"  \n        Dim TheIcon As Icon = IconFromFilePath(filePath)  \n\n        If TheIcon IsNot Nothing Then    \n            ''#Save it to disk, or do whatever you want with it.\n            Using stream As New System.IO.FileStream("c:\myfile.ico", IO.FileMode.CreateNew)\n                TheIcon.Save(stream)          \n            End Using\n        End If\n    End Sub\n\n    Public Function IconFromFilePath(filePath As String) As Icon\n        Dim result As Icon = Nothing\n        Try\n            result = Icon.ExtractAssociatedIcon(filePath)\n        Catch ''# swallow and return nothing. You could supply a default Icon here as well\n        End Try\n        Return result\n    End Function\nEnd Module