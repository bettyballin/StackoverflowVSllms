<?php\n// Database connection parameters\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database_name";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Calculate mean and standard deviation\n$query_mean = "SELECT AVG(stress_value) AS mean FROM health_data";\n$result_mean = $conn->query($query_mean);\n$mean = $result_mean->fetch_assoc()['mean'];\n\n$query_sd = "SELECT STDDEV(stress_value) AS sd FROM health_data";\n$result_sd = $conn->query($query_sd);\n$sd = $result_sd->fetch_assoc()['sd'];\n\n// Update benchmark table with new mean and sd\n$update_query = "UPDATE benchmark SET mean=$mean, standard_deviation=$sd WHERE id=1";\n$conn->query($update_query);\n\n$conn->close();\n?>