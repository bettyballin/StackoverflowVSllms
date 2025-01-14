-- Assuming your table is named `your_table` and the auto-increment column is `id`\n\n-- Generate the list of columns excluding `id`\nSET @columns = (\n    SELECT GROUP_CONCAT(column_name)\n    FROM information_schema.columns\n    WHERE table_schema = DATABASE()\n    AND table_name = 'your_table'\n    AND column_name != 'id'\n);\n\n-- Prepare the dynamic SQL query\nSET @query = CONCAT('INSERT INTO your_table (', @columns, ') ',\n                    'SELECT ', @columns, ' FROM your_table WHERE id = ?');\n\n-- Replace `?` with the id of the record you want to clone\nSET @id_to_clone = 1;  -- Change this to the ID of the record you want to clone\n\n-- Execute the dynamic SQL query\nPREPARE stmt FROM @query;\nEXECUTE stmt USING @id_to_clone;\nDEALLOCATE PREPARE stmt;