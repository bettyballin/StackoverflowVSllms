Try\n    Dim fileSizeInKB As Double = New FileInfo(FileName).Length / 1024\n    Dim formattedFileSize As String = fileSizeInKB.ToString("F1") & " KB"\nCatch ex As Exception\n    ' Handle the exception, e.g., log the error, display an error message, etc.\nEnd Try