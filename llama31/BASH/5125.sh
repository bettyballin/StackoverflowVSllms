for /f "tokens=*" %%d in ('dir /b /s /a:d *.svn') do rmdir /s /q "%%d"