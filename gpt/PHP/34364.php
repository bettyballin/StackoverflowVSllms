<?php\ninclude("run_connect.php"); // this connects to the database, this works\n\n// Escape the input to prevent SQL injection\n$first = mysql_real_escape_string($_POST['first']);\n\n$step1 = "INSERT INTO tblHurray (ID, first) VALUES ('', '$first')";\nmysql_query($step1) or die('Error: ' . mysql_error());\n\necho "$step1";\n\necho "<b><center>Database Output</center></b><br><br>";\n\n$step2 = mysql_query("SELECT * FROM tblHurray") or die('Error: ' . mysql_error());\n\n$num = mysql_numrows($step2);\n\n$i = 0;\nwhile ($i < $num) {\n    $firstname = mysql_result($step2, $i, "first");\n    $ID = mysql_result($step2, $i, "ID");\n    echo "$ID: $firstname<br />";\n    $i++;\n}\n?>