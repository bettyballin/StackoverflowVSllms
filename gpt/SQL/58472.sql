BULK INSERT YourTable\nFROM 'C:\path\to\file.txt'\nWITH (\n    FIELDTERMINATOR = ',',\n    ROWTERMINATOR = '\n',\n    FIRSTROW = 2\n);