// Retrieve a date from MySQL\n$result = mysql_query("SELECT UNIX_TIMESTAMP(date_column) AS date_column FROM table_name");\n$php_unix_timestamp = mysql_result($result, 0);\n\n// Insert a date into MySQL\n$php_unix_timestamp = strtotime('2012-12-25 12:00:00');\nmysql_query("INSERT INTO table_name (date_column) VALUES (FROM_UNIXTIME($php_unix_timestamp))");\n\n// Convert a MySQL date string to a Unix timestamp in PHP\n$mysql_date_string = '2012-12-25 12:00:00';\n$php_unix_timestamp = strtotime($mysql_date_string);\n\n// Convert a Unix timestamp to a MySQL date string in PHP\n$php_unix_timestamp = 1356434400;\n$mysql_date_string = date('Y-m-d H:i:s', $php_unix_timestamp);