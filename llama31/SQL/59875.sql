CREATE TEMPORARY TABLE temp_table AS\nSELECT * FROM original_table WHERE id = ?;\n\nUPDATE temp_table SET id = NULL;\n\nINSERT INTO original_table SELECT * FROM temp_table;