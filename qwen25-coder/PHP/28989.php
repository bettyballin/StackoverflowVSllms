$s1 = $sql->query('SELECT SQL_CALC_FOUND_ROWS * FROM db LIMIT 0, 3') or die($sql->error);\n   $s2 = $sql->query('SELECT FOUND_ROWS()') or die($sql->error);