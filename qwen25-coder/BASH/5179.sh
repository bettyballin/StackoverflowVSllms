:: PostInstallCleanup.bat\n@echo off\nregsvr32 /u /s "Path\To\Your\dll1.dll"\nregsvr32 /u /s "Path\To\Your\dll2.dll"\nregsvr32 /u /s "Path\To\Your\dll3.dll"\nregsvr32 /s "Path\To\Your\dll1.dll"\nregsvr32 /s "Path\To\Your\dll2.dll"\nregsvr32 /s "Path\To\Your\dll3.dll"