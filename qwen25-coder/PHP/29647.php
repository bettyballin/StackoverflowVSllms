$query = "SELECT $param FROM issues WHERE $param >= 0";\n$result = @mysql_query($query) or showError("query failed");\n$numbers = [];\n\nwhile ($record = mysql_fetch_assoc($result)) {\n    $numbers[] = $record[$param];\n}\n\nreturn $numbers;