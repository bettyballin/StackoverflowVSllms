INSERT INTO BusinessTransactionLog (Id, TransactionData)\nVALUES (1, 'some data');\n\nDECLARE @signature VARBINARY(MAX);\nSET @signature = ENCRYPTBYKEY(KEY_GUID('TamperEvidenceKey'), CONVERT(VARBINARY(MAX), 'some data'));\n\nUPDATE BusinessTransactionLog\nSET Signature = @signature\nWHERE Id = 1;