Dim urlPath As String = Request.Url.AbsolutePath\nDim folderName As String = urlPath.Split("/").Skip(1).Take(1).FirstOrDefault()\n\nIf Not String.IsNullOrEmpty(folderName) Then\n    Select Case folderName.ToLower()\n        Case "path1"\n            ' Change colors, etc. for path1\n        Case "path2"\n            ' Change colors, etc. for path2\n        Case Else\n            ' Handle unknown folder or throw an exception\n    End Select\nEnd If