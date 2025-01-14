-- Enabling TDE for a database named YourDatabase\n   USE master;\n   GO\n   CREATE MASTER KEY ENCRYPTION BY PASSWORD = 'strong_password';\n   CREATE CERTIFICATE TDECert WITH SUBJECT = 'TDE Certificate';\n   BACKUP CERTIFICATE TDECert TO FILE = 'C:\Backup\TDECert.cer' \n   ENCRYPTION BY PASSWORD = 'strong_password';\n   USE YourDatabase;\n   GO\n   CREATE DATABASE ENCRYPTION KEY WITH ALGORITHM = AES_128 \n   ENCRYPTION BY SERVER CERTIFICATE TDECert;\n   ALTER DATABASE YourDatabase SET ENCRYPTION ON;