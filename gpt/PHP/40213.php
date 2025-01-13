if ($_POST) {\n    $content = stripslashes($_POST['content']);\n    $by = $_SESSION['exp_user']['username'];\n    $dt = date("Y-m-d H:i:s"); // Use a format suitable for MySQL DATETIME\n\n    // Create a connection to the database (update with your connection details)\n    $mysqli = new mysqli("hostname", "username", "password", "database");\n\n    // Check connection\n    if ($mysqli->connect_error) {\n        die("Connection failed: " . $mysqli->connect_error);\n    }\n\n    // Prepare the SQL statement\n    $stmt = $mysqli->prepare("UPDATE tbl_intmsg SET time = ?, `by` = ?, content = ?");\n\n    // Bind parameters\n    $stmt->bind_param("sss", $dt, $by, $content);\n\n    // Execute the query\n    if ($stmt->execute()) {\n        echo "Record updated successfully";\n    } else {\n        echo "Error: " . $stmt->error;\n    }\n\n    // Close the statement and connection\n    $stmt->close();\n    $mysqli->close();\n}