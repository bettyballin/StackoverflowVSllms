ALTER TABLE [ActInv] ADD [BATCHNUMBER] NVARCHAR(50) NOT NULL CONSTRAINT ActInv_Temp DEFAULT 'foo'\nALTER TABLE [ActInv] DROP CONSTRAINT ActInv_Temp