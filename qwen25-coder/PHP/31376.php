// For INSERT\npg_prepare($pgconn, 'insert_null_val', "INSERT INTO my_table (col_a, col_b) VALUES ($1, $2)");\npg_exec($pgconn, 'insert_null_val', array('whatever', null));\n\n// For UPDATE\npg_prepare($pgconn, 'update_null_val', "UPDATE my_table SET col_b = $1 WHERE id = $2");\npg_exec($pgconn, 'update_null_val', array(null, some_id_value));