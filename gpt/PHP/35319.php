// Example of escaping a string\n$escaped_string = mysql_real_escape_string($input_string);\n\n// Store $escaped_string in the database\n\n// Retrieve the string from the database\n$retrieved_string = $result_from_database;\n\n// Unescape the string\n$unescaped_string = stripslashes($retrieved_string);\n\necho $unescaped_string;