$sql = mysql_query("SELECT * FROM comments WHERE user = 1");\n$number = mysql_num_rows($sql);\n$i = 1;\nwhile ($row = mysql_fetch_assoc($sql)) {\n\n   echo '<p>' . $i . $row['comment'] . '</p>';\n\n   if ($i < $number)\n   {\n       echo '<div class="border"></div>';\n   }\n\n   $i ++;\n}