$con = new mysqli("localhost", "abc", "xyz", "database_name");\nif ($con->connect_error) {\n    // Handle the error\n    echo "Error: " . $con->connect_error;\n    exit();\n}\n\n// Your parsing and database operations go here\n\n// Close the connection when you're done\n$con->close();