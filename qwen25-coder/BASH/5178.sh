@echo off\nsetlocal\nset PORT=8080\n\nnetstat -aon | findstr :%PORT%\nif %errorlevel%==0 (\n    echo Port %PORT% is in use.\n) else (\n    echo Port %PORT% is available.\n)\nendlocal