-- Create a Sequence in MS SQL Server\nCREATE SEQUENCE supplier_seq \nAS BIGINT -- or any other numeric type as needed\nSTART WITH 1\nINCREMENT BY 1\nMINVALUE 1\nMAXVALUE 999999999999999999 -- Adjust according to your MAXVALUE need, ensure it's compatible with the data type chosen\nCACHE 20;\n\n-- Retrieve the next value from the sequence\nSELECT NEXT VALUE FOR supplier_seq AS NextSequenceValue;