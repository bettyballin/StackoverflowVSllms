dim strComputer = "." 'Define here the Remote IP Address or Computername\ndim objWMIService\ndim colLogFiles\ndim objLogfile\ndim errBackupLog\n\nSet objWMIService = GetObject("winmgmts:" & "{impersonationLevel=impersonate,(Backup)}!\\" &  strComputer & "\root\cimv2")\n\nCall eventlogbackup("Application")\nCall eventlogbackup("System")\nCall eventlogbackup("Security")\n\nFunction eventlogbackup(logtype)\n\nSet colLogFiles = objWMIService.ExecQuery ("SELECT * FROM Win32_NTEventLogFile WHERE LogFileName='" & logtype & "'")\n\nFor Each objLogfile in colLogFiles\n errBackupLog = objLogFile.BackupEventLog("\\server\eventlogs\" & strComputer & "\" &logtype & ".evt")\n If errBackupLog <> 0 Then\n    Wscript.Echo "The " & logtype &" event log could not be backed up."\n Else\n    objLogFile.ClearEventLog()\n    Wscript.Echo "The " & logtype &" event log is backed up."\n End If\nNext\n\nEnd Functio