Dim filePath As String = upddir & "\app.exe"\nIf Not IsFileInUse(filePath) Then\n    ' Safe to proceed with updating or renaming the file\nElse\n    ' File is in use, handle accordingly (wait, abort update, etc.)\nEnd If