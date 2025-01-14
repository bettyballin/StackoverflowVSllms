BEGIN TRY\n    OPEN SYMMETRIC KEY MySymmetricKey DECRYPTION BY CERTIFICATE MyCertificate;\n\n    -- Your SQL logic here\n    INSERT INTO EncryptedData (EncryptedColumn) VALUES(EncryptByKey(Key_GUID('MySymmetricKey'), 'Sensitive Data'));\n\nEND TRY\nBEGIN CATCH\n    CLOSE SYMMETRIC KEY MySymmetricKey;\n    ROLLBACK TRANSACTION; -- Assuming you've started a transaction\n    THROW; -- Re-throw the caught error after cleaning up\nEND CATCH\nFINALLY\n    CLOSE SYMMETRIC KEY MySymmetricKey;