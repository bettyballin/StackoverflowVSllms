@echo off\nsetlocal enabledelayedexpansion\n\n:: Run the batch file with elevated privileges\nopenfiles > NUL 2>&1\nif %errorlevel%==0 (\n    goto :main\n) else (\n    powershell -Command "Start-Process 'cmd' -Verb RunAs -ArgumentList '/c, ""%~f0""""\n    exit /b\n)\n\n:main\n:: Your code to delete files goes here\ndel /f /q "C:\Windows\file_to_delete.txt"