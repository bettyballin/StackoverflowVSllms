UPDATE YourTableName\nSET YourNewField = \n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26) +\n    CHAR(65 + ABS(CHECKSUM(NEWID())) % 26)