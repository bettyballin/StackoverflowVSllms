mysql_query(sprintf("UPDATE offtopic SET next = '%s' WHERE id = '%s'",\n            mysql_real_escape_string($insert),\n            mysql_real_escape_string($id));