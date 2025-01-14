Function CleanText(inputString As String) As String\n    ' Remove line feeds (LF)\n    inputString = Replace(inputString, Chr(10), "")\n    ' Optionally also remove carriage returns (CR)\n    inputString = Replace(inputString, Chr(13), "")\n    ' Or use vbCrLf if you want to remove both in one go\n    ' inputString = Replace(inputString, vbCrLf, "")\n    CleanText = inputString\nEnd Functio