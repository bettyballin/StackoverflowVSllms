SELECT TOP 5 Id, Name\nFROM customerNames\nORDER BY CHECKSUM(NEWID()) * RAND()