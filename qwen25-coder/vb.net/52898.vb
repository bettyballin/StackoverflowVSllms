On Error GoTo ErrorHandler\n   Set obj = CreateObject("YourNamespace.YourClass")\n   Exit Sub\n\nErrorHandler:\n   MsgBox Err.Descriptio