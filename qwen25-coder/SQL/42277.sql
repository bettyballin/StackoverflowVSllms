DELETE FROM [Progress_Database_Table]\nWHERE subsNumber NOT IN (\n    SELECT subsNumber FROM [SQL_Server_Table]\n);