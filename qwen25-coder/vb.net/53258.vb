Dim fileSizeInBytes As Long = New FileInfo(FileName).Length\nDim fileSizeInKB As Double = fileSizeInBytes / 1024\nConsole.WriteLine(fileSizeInKB.ToString("F1") & " KB")