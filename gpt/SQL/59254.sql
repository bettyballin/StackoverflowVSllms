-- Step 1: Create a temporary table with an auto-increment ID\nCREATE TEMPORARY TABLE temp_table (\n    temp_id INT AUTO_INCREMENT PRIMARY KEY,\n    original_date VARCHAR(10) -- Adjust the data type to match your table's column\n);\n\n-- Step 2: Insert the original records into the temporary table\nINSERT INTO temp_table (original_date)\nSELECT original_date FROM your_table;\n\n-- Step 3: Perform the update on the temporary table\nUPDATE temp_table\nSET original_date = UNIX_TIMESTAMP(STR_TO_DATE(original_date, '%Y-%m-%d'));\n\n-- Step 4: Optionally update the original table if needed\nUPDATE your_table t\nJOIN temp_table tmp ON t.original_date = tmp.original_date\nSET t.original_date = tmp.original_date;\n\n-- Step 5: Drop the temporary table\nDROP TEMPORARY TABLE temp_table;