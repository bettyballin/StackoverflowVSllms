Imports System.IO\n\nPublic Function ReadAndModifyRTF(filePath As String) As String\n    Dim fileContent As String\n\n    ' Use a Using statement to ensure the StreamReader is closed and disposed.\n    Using reader As New StreamReader(filePath)\n        fileContent = reader.ReadToEnd()\n    End Using\n\n    ' Modify your string here.\n    fileContent = fileContent.Replace("oldText", "newText")\n\n    Return fileContent\nEnd Functio