$guests = array();\n$sql = "SELECT * FROM `guestlist`";\n$result = mysql_query($sql);\nwhile(($row = mysql_fetch_assoc($result)) !== false)\n    $guests[] = $row['name'];