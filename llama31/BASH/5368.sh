@echo off\nfor /f "tokens=*" %%f in ('dir /b /a-d *.asp') do (\n    regsvr32 /n /i "%%f" > nul\n    if !errorlevel! equ 0 (\n        echo %%f: COM objects found\n        regsvr32 /n /i "%%f" | findstr /i "CLSID"\n    )\n)