$sectorlink = mysql_real_escape_string($sectorlink); // Sanitize input\n$query1 = "SELECT name FROM clients WHERE sector = '$sectorlink'";\n$clientresult = mysql_query($query1, $connection) or trigger_error("SQL", E_USER_ERROR);\n\n$names = array();\nwhile ($row = mysql_fetch_assoc($clientresult)) {\n    $names[] = "'" . mysql_real_escape_string($row['name']) . "'";\n}\n\nif (!empty($names)) {\n    $thelist = implode(",", $names);\n    $query2 = "SELECT * FROM studies WHERE client IN ($thelist) ORDER BY date DESC";\n    $result = mysql_query($query2, $connection) or trigger_error("SQL", E_USER_ERROR);\n\n    // Process the results of $query2 as needed\n} else {\n    echo "No clients found for the specified sector.";\n}