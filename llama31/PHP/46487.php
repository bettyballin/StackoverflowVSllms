<?php\nrequire_once('connect.php');\n\n$arr = array(...); // your JSON object\n\n$output = json_encode($arr, JSON_UNESCAPED_SLASHES);\n\n$ergebnis = mysql_query("SELECT text FROM cache_table ORDER BY RAND() LIMIT 1");\nwhile($row = mysql_fetch_object($ergebnis)) {\n    $output = $row->text;\n}\n\necho $output;