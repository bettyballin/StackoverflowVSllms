$result = mysql_query("SELECT COUNT(*) as row_count FROM your_table");\n$row = mysql_fetch_assoc($result);\n$row_count = $row['row_count'];