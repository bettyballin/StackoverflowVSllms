BULK INSERT sometable\nFROM 'E:\filefromabove.txt'\nWITH (\n    FIRSTROW = 2,\n    FIELDTERMINATOR = '|',\n    ROWTERMINATOR = '\r\n'  -- Try this if your file uses CRLF line endings.\n)