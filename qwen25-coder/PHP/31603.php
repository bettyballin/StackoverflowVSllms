<?php\nrequire_once('../scripts/config.php');\n\n$date = $GLOBALS['HTTP_RAW_POST_DATA'];\n\n$query = mysql_query("SELECT * FROM eventcal WHERE eventDate = '$date'");\n\n$results = array();\nif (@mysql_num_rows($query)) {\n    while ($r = @mysql_fetch_assoc($query)) {\n        $results[] = $r;\n    }\n}\n\n// Use json_encode to convert the PHP array into a JSON string\necho json_encode($results);\n?>