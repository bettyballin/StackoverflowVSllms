<%\nDim oShell, sCommand, sOutput\n\n' Create WScript.Shell object\nSet oShell = Server.CreateObject("WScript.Shell")\n\n' Define the path to your Python executable and the script you want to run\n' Make sure to use full paths\nsCommand = "C:\Path\To\Python\python.exe C:\Path\To\YourScript\script.py"\n\n' Execute the command\nSet sOutput = oShell.Exec(sCommand)\n\n' Capture output if needed (e.g., the script prints something)\nDim oStreamReader, sResult\nSet oStreamReader = sOutput.StdOut\nsResult = oStreamReader.ReadAll\n\nResponse.Write "Output from Python Script: " & Server.HTMLEncode(sResult)\n\n' Clean up\nSet oStreamReader = Nothing\nSet sOutput = Nothing\nSet oShell = Nothing\n%>