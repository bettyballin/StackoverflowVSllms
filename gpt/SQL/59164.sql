-- Example of cell-level encryption\n   CREATE TABLE MyTable (\n       ID INT PRIMARY KEY,\n       SensitiveData VARBINARY(MAX)\n   );\n\n   -- Encrypt data\n   DECLARE @Key VARBINARY(32);\n   -- Generate a symmetric key\n   SET @Key = (SELECT EncryptByPassPhrase('MyPassPhrase', 'MySecretKey'));\n\n   INSERT INTO MyTable (ID, SensitiveData)\n   VALUES (1, EncryptByKey(Key_GUID('MySymmetricKey'), 'Sensitive Information'));\n\n   -- Decrypt data\n   SELECT ID, CONVERT(VARCHAR, DecryptByKey(SensitiveData))\n   FROM MyTable;