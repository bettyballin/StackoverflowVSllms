SELECT TOP 1 *\nFROM OPENROWSET('Microsoft.ACE.OLEDB.12.0', \n    'Excel 12.0;Database=C:\path\to\your\file.xlsx;HDR=YES', \n    'SELECT * FROM [Sheet1$]')