Try\n    Using OutFile As New System.IO.StreamWriter(Filename)\n        ' Do stuff with OutFile\n    End Using\nCatch Ex As Exception\n    ' Handle Exception\nEnd Try