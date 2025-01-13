<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    $sdate = $_POST['sdate'];\n    $edate = $_POST['edate'];\n\n    // Validate the input dates\n    if (DateTime::createFromFormat('Y-m-d', $sdate) === FALSE || DateTime::createFromFormat('Y-m-d', $edate) === FALSE) {\n        die('Invalid date format. Please enter the date in YYYY-MM-DD format.');\n    }\n\n    // Establish the database connection (replace with your own connection parameters)\n    $servername = "your_servername";\n    $username = "your_username";\n    $password = "your_password";\n    $dbname = "your_dbname";\n\n    $conn = new mysqli($servername, $username, $password, $dbname);\n\n    // Check connection\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    // Prepare the query\n    $stmt = $conn->prepare("SELECT sdate, project_name, edate FROM projects WHERE sdate BETWEEN ? AND ? OR edate BETWEEN ? AND ?");\n    $stmt->bind_param("ssss", $sdate, $edate, $sdate, $edate);\n\n    // Execute the query\n    $stmt->execute();\n    $result = $stmt->get_result();\n\n    // Display the results\n    if ($result->num_rows > 0) {\n        while ($row = $result->fetch_assoc()) {\n            echo $row['sdate'] . " " . $row['project_name'] . " " . $row['edate'] . "<br />";\n        }\n    } else {\n        echo "No results found.";\n    }\n\n    // Close the connection\n    $stmt->close();\n    $conn->close();\n}\n?>