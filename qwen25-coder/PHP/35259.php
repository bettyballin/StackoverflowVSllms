// Assuming $conn is your MySQLi connection and $input is the string you want to escape\n\n$input = "O'Reilly";\n\n$escaped_addslashes = addslashes($input);\necho $escaped_addslashes; // Outputs: O\'Reilly\n\n$escaped_real_escape_string = mysqli_real_escape_string($conn, $input);\necho $escaped_real_escape_string; // Also outputs: O\'Reilly