SET ANSI_NULLS ON\n\nDECLARE @MiddleName VARCHAR(20);\nSET @MiddleName = NULL;\n\nSELECT * \nFROM [Customer]\nWHERE [LastName] = 'Torres'\nAND (@MiddleName IS NULL OR [MiddleName] = @MiddleName)