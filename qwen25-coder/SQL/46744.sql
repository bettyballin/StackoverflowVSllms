SET @search_letter = 'a';\nSET @query = CONCAT("SELECT * FROM your_table WHERE LOWER(column_name) REGEXP '(^|[[:space:]])", LOWER(@search_letter), "[[:word:]]*'");\n\nPREPARE stmt FROM @query;\nEXECUTE stmt;\nDEALLOCATE PREPARE stmt;