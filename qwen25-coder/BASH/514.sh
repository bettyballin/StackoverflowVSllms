@echo off\nsetlocal enabledelayedexpansion\n\nrem Start timing\nfor /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value') do set datetime=%%I\nset start_time=!datetime:~8,4!!datetime:~12,2!!datetime:~14,2!\n\nrem Run the build command\nmsbuild YourProject.sln /p:Configuration=Release\n\nrem End timing\nfor /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value') do set datetime=%%I\nset end_time=!datetime:~8,4!!datetime:~12,2!!datetime:~14,2!\n\nrem Calculate elapsed time (hhmmss)\nset /a elapsed=!end_time! - !start_time!\necho Elapsed Time: %elapsed:~0,2%:%elapsed:~2,2%:%elapsed:~4%\n\nendlocal