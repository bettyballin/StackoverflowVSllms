SELECT * \nFROM OPENROWSET(BULK 'C:\foo.txt', SINGLE_BLOB) AS contents