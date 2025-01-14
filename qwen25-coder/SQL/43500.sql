-- Begin a transaction\nBEGIN TRANSACTION;\n\n-- Take an exclusive lock on the entire table\nSELECT * FROM YourTableName WITH (TABLOCKX)\nWHERE 1 = 0; -- Use WHERE 1=0 to avoid actually selecting rows\n\n-- Introduce a delay to simulate a long-running query\nWAITFOR DELAY '00:02'; -- Adjust the time as necessary\n\n-- Commit or rollback the transaction after testing\nCOMMIT TRANSACTION;\n-- OR ROLLBACK TRANSACTION;