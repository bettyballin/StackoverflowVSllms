Dim myTemp As String\nmyTemp = System.DateTime.Now().ToString("MMMddyyyy_HHmmss") & ".pdf"\n\nSystem.IO.File.Copy(myFile, "c:\" & myTemp)\n\nWhile Not System.IO.File.Exists("c:\" & myTemp)\n    Application.DoEvents()\n    System.Threading.Thread.Sleep(100) ' wait 100ms before checking again\nEnd While\n\nOpenFile(myTemp)