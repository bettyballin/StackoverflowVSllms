DECLARE @Checksum FLOAT\nEXEC Get_Checksum 'YourDatabaseName', 'YourTableName', @Checksum OUTPUT\nSELECT @Checksum