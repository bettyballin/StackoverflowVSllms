DECLARE @InsertScript NVARCHAR(MAX)\n   SET @InsertScript = 'INSERT INTO TargetTable (BLOBColumn) VALUES (CAST(''' + @Base64Encoded + ''' AS XML).value(''xs:base64Binary(.)'', ''VARBINARY(MAX)''))'\n\n   PRINT @InsertScript