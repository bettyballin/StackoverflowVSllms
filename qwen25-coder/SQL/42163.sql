-- Assume we have a table named 'test_table' with a primary key 'id'\n-- and some other column 'value'.\n\n-- Insert test data\nINSERT INTO test_table (id, value) VALUES (1, 10);\nCOMMIT;\n\n-- Start transaction in serializable mode\nSET TRANSACTION ISOLATION LEVEL SERIALIZABLE;\nBEGIN\n    -- Read the row\n    SELECT * FROM test_table WHERE id = 1 FOR UPDATE;\n    \n    -- Modify the same row elsewhere in logic or by a trigger\n    -- For demonstration, we'll do it manually here\n    UPDATE test_table SET value = 20 WHERE id = 1;\n    \n    -- Attempt to modify the row again in the same transaction\n    UPDATE test_table SET value = 30 WHERE id = 1;\nEND;\n-- This might lead to ORA-08177 depending on Oracle's internal behavior and locking.