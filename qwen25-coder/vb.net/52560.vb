Imports System.IO\n\nPublic Function IsFileInUse(file As String) As Boolean\n    Try\n        Using inputStream = File.Open(file, FileMode.Open, FileAccess.Read, FileShare.None)\n            inputStream.Close()\n        End Using\n    Catch ex As IOException\n        ' The file is unavailable because it is:\n        ' still being written to\n        ' or opened by another process\n        Return True\n    End Try\n\n    ' File is not open\n    Return False\nEnd Functio