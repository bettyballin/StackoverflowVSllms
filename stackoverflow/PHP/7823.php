echo "<table>";\n\nwhile ($row_users = mysql_fetch_array($results)) {\n    //output a row here\n    echo "<tr><td>".($row_users['email'])."</td></tr>";\n}\n\necho "</table>";