BULK INSERT CSVTest\nFROM 'c:\csvfile.txt'\nWITH (\n    FORMATFILE = 'c:\formatfile.fmt',\n    ROWTERMINATOR = '\n'\n)\nGO