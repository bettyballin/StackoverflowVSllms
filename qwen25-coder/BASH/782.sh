@echo off\nsetlocal\n\nREM Replace "YourServiceName" with the name of your service.\nset SERVICE_NAME=YourServiceName\n\npowershell -Command ^\n    "$service = Get-Service '%SERVICE_NAME%' -ErrorAction SilentlyContinue; " ^\n    "if ($null -eq $service) { exit 1 } else { exit 0 }"\n\nif %errorlevel% equ 0 (\n    echo Service is installed.\n) else (\n    echo Service is not installed.\n)\n\nendlocal