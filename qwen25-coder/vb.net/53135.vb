Public Sub DllRegisterServer()\n    On Error GoTo err_fail\n    ' Code to register your DCOM object\n    MsgBox "Successfully registered"\n    Exit Sub\n\nerr_fail:\n    MsgBox Err.Description, vbCritical, "Registration Failed"\nEnd Sub