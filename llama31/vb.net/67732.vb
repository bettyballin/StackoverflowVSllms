Declare PtrSafe Function GetCurrentProcessId Lib "kernel32" () As Long\n\nSub GetProcessID()\n    Dim pid As Long\n    pid = GetCurrentProcessId\n    Debug.Print pid\nEnd Sub