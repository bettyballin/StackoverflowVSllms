$conn1 = mysql_connect('localhost', 'root', '', TRUE);\nmysql_select_db('dredd', $conn1);\n\nfunction show($conn) {\n    $a = mysql_fetch_array(mysql_query('select database()', $conn));\n    echo $a[0] . "<br>";\n}\n\nshow($conn1);\n\n$conn2 = mysql_connect('localhost', 'root', '', TRUE);\nmysql_select_db('afup', $conn2);\nshow($conn2);\n\nmysql_close($conn2);\n\n// Use the first connection again\nshow($conn1);