<?php\n$result = mysql_query("SELECT * FROM mydb");\n$num_rows = mysql_num_rows($result);\necho "<h1>$num_rows</h1><h2>rows</h2>";\n?>