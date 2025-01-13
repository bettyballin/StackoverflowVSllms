-- Create a table with some data\nCREATE TABLE test_table (id NUMBER PRIMARY KEY, value NUMBER);\n\nINSERT INTO test_table (id, value) VALUES (1, 10);\nCOMMIT;\n\n-- Set the isolation level to serializable\nALTER SESSION SET ISOLATION_LEVEL = SERIALIZABLE;\n\n-- Start a transaction\nBEGIN\n    -- Read the current value\n    SELECT value INTO :old_value FROM test_table WHERE id = 1;\n\n    -- Modify the value in another statement (simulating another transaction)\n    UPDATE test_table SET value = 20 WHERE id = 1;\n    COMMIT;\n\n    -- Try to update the value again in the original transaction\n    UPDATE test_table SET value = 30 WHERE id = 1;\n    COMMIT;\nEND;