\nstrComputer = "."\nSet objWMIService = GetObject("winmgmts:\\" & strComputer & "\root\cimv2")\n\nSet colDisks = objWMIService.ExecQuery("Select * from Win32_LogicalDisk where MediaType = 11")\n\nFor Each objDisk in colDisks\n    Wscript.Echo objDisk.DeviceID & objDisk.Description\nNext