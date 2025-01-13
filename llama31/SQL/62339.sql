DECLARE @password nvarchar(50) = 'abc';\nDECLARE @encrypted1 varbinary(128) = PWDEncrypt(@password);\nDECLARE @encrypted2 varbinary(128) = PWDEncrypt(@password);\n\nIF PWDCompare(@password, @encrypted1) = 1 AND PWDCompare(@password, @encrypted2) = 1\n    PRINT 'The two binary values are hashes of the same password';\nELSE\n    PRINT 'The two binary values are not hashes of the same password';