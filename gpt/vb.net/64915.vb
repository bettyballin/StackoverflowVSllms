Dim filePath As String\nfilePath = Server.MapPath("~/photos/") & fileName\n\nIf Not System.IO.File.Exists(filePath) Then\n    Throw New Exception("File does not exist: " & filePath)\nEnd If