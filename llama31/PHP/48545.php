$query = "INSERT INTO table_name (column1, column2) VALUES ('value1', 'value2')";\nmysql_query($query);\n$new_id = mysql_insert_id();