CREATE TABLE MyTable (\n    Data VARBINARY(MAX),\n    WrappedKey VARBINARY(MAX)\n);\n\nINSERT INTO MyTable (Data, WrappedKey)\nVALUES (ENCRYPTBYKEY(MySymmetricKey, 'data_to_encrypt'), MyWrappedSymmetricKey);