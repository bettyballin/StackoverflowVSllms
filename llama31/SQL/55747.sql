BULK INSERT sometable\nFROM 'E:\filefromabove.txt'\nWITH\n(\n    FIRSTROW = 1,\n    FIELDTERMINATOR = '|',\n    ROWTERMINATOR = '\n',\n    IGNOREBLANKROWS = 1\n)