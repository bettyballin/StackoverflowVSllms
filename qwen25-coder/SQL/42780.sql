BEGIN\n    SELECT COUNT(*) INTO v_count FROM your_table;\n    DELETE FROM your_table WHERE condition = 'value';\nEND;\n/