while ($row = mysql_fetch_object($result)) {\n    echo $row->user_id;\n    echo $row->fullname;\n}