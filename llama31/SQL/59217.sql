BULK INSERT YourTable\nFROM 'C:\YourFile.txt'\nWITH\n(\n    FIELDTERMINATOR = ',',\n    ROWTERMINATOR = '\n',\n    TABLOCK,\n    OPTION (MAXDOP 0)\n);