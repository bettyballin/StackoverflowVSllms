while ($row = mysql_fetch_array($employeeNames, MYSQL_ASSOC)) {\n    echo $row['full_name'];\n}