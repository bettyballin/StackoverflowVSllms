Public Sub ServeReport(ByVal URL As String, _\n    ByVal Directory As String, ByVal Filename As String)\n\n    Dim f As New FileIOPermission(PermissionState.None)\n    Dim fs As FileStream\n\n    If Not System.IO.Directory.Exists(Directory) Then\n        System.IO.Directory.CreateDirectory(Directory)\n    End If\n\n    DownloadWebFile(URL, Directory & Filename)    \n\n    fs = File.Open(Directory & Filename, FileMode.Open)\n\n    Dim bytBytes(fs.Length) As Byte\n    fs.Read(bytBytes, 0, fs.Length)\n    fs.Close()\n\n    Response.AddHeader("Content-disposition", _\n               "attachment; filename=" & Filename)\n    Response.ContentType = "application/octet-stream"\n    Response.BinaryWrite(bytBytes)\n\n    f.AllLocalFiles = FileIOPermissionAccess.AllAccess\n    File.Delete(Directory & Filename)\nEnd Sub