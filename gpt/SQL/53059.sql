DECLARE @Ids VARCHAR(50);\nSET @Ids = '1,2,3,5,4,6,7,98,234';\n\nSELECT * \nFROM sometable \nWHERE tableid IN (SELECT Value FROM dbo.SplitString(@Ids, ','));