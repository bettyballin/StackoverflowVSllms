DECLARE @Rowversion BIGINT;\nSET @Rowversion = CAST(@BinaryTimestamp AS BIGINT);\n\nSELECT @Rowversion AS Rowversion;