-- Before\nUPDATE #temp_table\nSET column1 = 'value1'\nWHERE condition1 = 'true';\n\nUPDATE #temp_table\nSET column1 = 'value2'\nWHERE condition2 = 'true';\n\n-- After\nUPDATE #temp_table\nSET column1 = CASE\n    WHEN condition1 = 'true' THEN 'value1'\n    WHEN condition2 = 'true' THEN 'value2'\n    ELSE column1\nEND;