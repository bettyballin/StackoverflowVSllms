@echo OFF\n\n:: Force a new line and add a marker; assuming your file is data.txt.\n@echo. >> data.txt\n@echo **MARKER** >> data.txt\n\n:: Run your export here: these lines just simulate the export.\n@echo Test Line 1 >> data.txt\n@echo Test Line 2 >> data.txt\n\n:: Find line number of last marker:\nfor /f "usebackq delims=:" %%I in (`findstr /N "**MARKER**" data.txt`) do (\n    set LAST_MARKER=%%I\n)\n\n:: Get all the lines after the last marker\nfor /f "skip=%LAST_MARKER% tokens=*" %%L in (data.txt) do (\n    @echo %%L >> new_data.txt\n)