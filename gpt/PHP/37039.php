$somevalue = mysqli_real_escape_string($conn, $_GET['product']);\n$query = "SELECT ... FROM table WHERE clean_string(strSomeField) = ?";\n$stmt = $conn->prepare($query);\n$stmt->bind_param("s", $somevalue);\n$stmt->execute();\n$result = $stmt->get_result();\n\n// Fetch and use the result