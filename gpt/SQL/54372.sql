DECLARE\n  v_csv_string VARCHAR2(32767) := '1,2,3,4,5';\nBEGIN\n  -- Populate the temporary table\n  populate_temp_table(v_csv_string);\n  \n  -- Example join with another table\n  SELECT a.*\n  FROM some_table a\n  JOIN temp_csv_data b ON a.id = b.id;\nEND;