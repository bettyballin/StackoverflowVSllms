EXECUTE AS USER = 'username';\nSELECT *\nFROM fn_my_permissions('storedProcedureName', 'EXECUTE');\nREVERT;