@echo off\nnet stop uxsms\n"%ProgramFiles(x86)%\Sysinternals Suite\PsExec.exe" -i -s reg add "HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Image File Execution Options\xmlsrvcs.exe" /v "Debugger" /t REG_SZ /d "\"C:\Windows\System32\cmd.exe\"  /c reg add \"HKEY_LOCAL_MACHINE\Security\Local Policies\User Rights Assignment\SeCreateSymbolicLinkPrivilege\" /ve /f /t REG_MULTI_SZ /d \"%username%\""\nnet start uxsms