-- Step 1: Create an audit table for storing changes\nCREATE TABLE update_audit (\n    id NUMBER GENERATED BY DEFAULT AS IDENTITY,\n    table_name VARCHAR2(30),\n    primary_key_value VARCHAR2(50), -- Adjust the size as necessary\n    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,\n    updated_by VARCHAR2(30) DEFAULT USER,\n    new_col1_value VARCHAR2(4000),  -- Add columns for each column you want to log\n    old_col1_value VARCHAR2(4000)\n);\n\n-- Step 2: Create a trigger on the table you want to monitor (e.g., target_table)\nCREATE OR REPLACE TRIGGER trg_target_table_update_audit\nAFTER UPDATE ON target_table\nFOR EACH ROW\nBEGIN\n    -- Insert details into the audit table for the updated row\n    INSERT INTO update_audit (\n        table_name,\n        primary_key_value,  -- Make sure to put your table's PK column value here\n        new_col1_value,       -- Replace with actual column names you want to log\n        old_col1_value\n    ) VALUES (\n        'target_table',\n        :OLD.primary_key_column,  -- Remember to use the correct primary key column of your table\n        :NEW.column_to_log,\n        :OLD.column_to_log\n    );\nEND;\n/