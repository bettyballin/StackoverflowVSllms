Dim myTemp As String\nmyTemp = System.DateTime.Now().ToString("MMMddyyyy_HHmmss") & ".pdf"\n\n' Copy the file synchronously\nSystem.IO.File.Copy(myFile, "c:\" & myTemp)\n\n' Wait for a short period to ensure the file system has registered the new file\nSystem.Threading.Thread.Sleep(100) ' in milliseconds\n\nOpenFile(myTemp)