Dim fileSizeInKB As Double = New FileInfo(FileName).Length / 1024\nDim formattedFileSize As String = fileSizeInKB.ToString("F1") & " KB"