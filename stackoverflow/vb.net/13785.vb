' This works on my machine... '\nOption Explicit\nDim objWMIService, procs, proc, creationDate\nSet objWMIService = GetObject("winmgmts:" _\n& "{impersonationLevel=impersonate}!\\.\root\cimv2") \n\nSet procs = objWMIService.ExecQuery ("Select * from Win32_Process where name='inetinfo.exe'")\n\nFor Each proc In procs\n  creationDate = creationDate & vbCr & proc.CreationDate\nNext