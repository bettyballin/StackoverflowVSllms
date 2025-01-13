@echo off\n     echo Restarting IIS...\n     iisreset /stop\n     if errorlevel 1 (\n         echo Failed to stop IIS. Exiting...\n         exit /B %errorlevel%\n     )\n     \n     iisreset /start\n     if errorlevel 1 (\n         echo Failed to start IIS. Exiting...\n         exit /B %errorlevel%\n     )\n     echo IIS restarted successfully.