CREATE PROCEDURE EncryptDataInColumn\nAS\nBEGIN\n    UPDATE YourTable\n    SET SensitiveDataEncrypted = ENCRYPTBYPASSPHRASE('YourStrongPassPhrase', SensitiveData)\nEND