reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v KeepAliveTimeout /t REG_DWORD /d 1000 /f\n   reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v DisableKeepAlives /t REG_DWORD /d 1 /f