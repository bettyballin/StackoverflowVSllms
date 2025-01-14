echo "MySQL Server Info: " . $sql->server_info . "\n";\n   echo "Connected Database: " . $sql->query("SELECT DATABASE()")->fetch_row()[0] . "\n";\n\n   $s1 = $sql->query('SELECT SQL_CALC_FOUND_ROWS * FROM db LIMIT 0, 3');\n   if (!$s1) {\n       die('Query error: ' . $sql->error);\n   }\n\n   $s2 = $sql->query('SELECT FOUND_ROWS()');\n   if (!$s2) {\n       die('Found rows query error: ' . $sql->error);\n   }\n\n   if ($row2 = $s2->fetch_row()) {\n       printf('%d/%d', $s1->num_rows, $row2[0]);\n   } else {\n       echo "Failed to fetch found rows.";\n   }