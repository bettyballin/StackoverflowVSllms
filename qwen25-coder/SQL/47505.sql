CREATE OR REPLACE PROCEDURE get_lob_data(\n    p_column_a OUT VARCHAR2,  -- Assuming column_a is not a LOB\n    p_lob_locator IN CLOB\n) IS\nBEGIN\n    -- Logic to handle the LOB data in your local session.\n    -- For example, you can read from or write to it as needed.\n    p_column_a := 'Data fetched successfully';\n    DBMS_OUTPUT.PUT_LINE('LOB size: ' || DBMS_LOB.GETLENGTH(p_lob_locator));\nEND;\n/\n\nDECLARE\n    v_column_a VARCHAR2(100);\nBEGIN\n    -- Fetch non-LOB column and pass LOB locator to a PL/SQL block\n    FOR rec IN (\n        SELECT column_a, column_clob -- Assuming column_clob is the LOB column\n        FROM data_user.sample_table@TEST_LINK\n        WHERE some_condition\n    ) LOOP\n        -- Call your PL/SQL procedure with the non-LOB column and LOB locator\n        get_lob_data(v_column_a, rec.column_clob);\n    END LOOP;\nEND;\n/