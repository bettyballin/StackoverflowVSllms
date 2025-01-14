$table_name = 'your_table';\n$id = 123;\n\n// Ensure to properly escape and validate your variables before using them in a query\n$query = sprintf("SELECT COUNT(*) AS test FROM %s WHERE id = %d AND tmp_mail <> ''", $table_name, $id);\n\necho $query; \n// Output: SELECT COUNT(*) AS test FROM your_table WHERE id = 123 AND tmp_mail <> ''