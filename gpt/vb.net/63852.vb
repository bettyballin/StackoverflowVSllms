' Example of logging user activity\n   Dim fso, logFile\n   Set fso = Server.CreateObject("Scripting.FileSystemObject")\n   Set logFile = fso.OpenTextFile(Server.MapPath("log.txt"), 8, True)\n   logFile.WriteLine("User " & Session.SessionID & " accessed " & Request.ServerVariables("SCRIPT_NAME") & " at " & Now)\n   logFile.Close\n   Set logFile = Nothing\n   Set fso = Nothing