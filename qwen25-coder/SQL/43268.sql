CREATE ASSEMBLY SymmetricEncryptionAssembly\nFROM 'C:\Path\To\Your\Assembly.dll'\nWITH PERMISSION_SET = SAFE;\nGO\n\nCREATE PROCEDURE EncryptData\n    @plainText NVARCHAR(MAX),\n    @key NVARCHAR(128),\n    @encryptedData VARBINARY(MAX) OUTPUT\nAS EXTERNAL NAME SymmetricEncryptionAssembly.[SymmetricEncryption].EncryptData;\n\nCREATE PROCEDURE DecryptData\n    @cipherText VARBINARY(MAX),\n    @key NVARCHAR(128),\n    @plainText NVARCHAR(MAX) OUTPUT\nAS EXTERNAL NAME SymmetricEncryptionAssembly.[SymmetricEncryption].DecryptData;