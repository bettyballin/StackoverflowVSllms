$teamName = mysql_real_escape_string("1st Level Technical Support_a");\n$employeeNames = mysql_query("SELECT * FROM employees WHERE team=\"$teamName\" LIMIT 0,5000") or die(mysql_error());