<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $day = $_POST['day'];\n    $month = $_POST['month'];\n    $year = $_POST['year'];\n\n    // Validate the date\n    if (checkdate($month, $day, $year)) {\n        $dob = "$year-$month-$day"; // Format as YYYY-MM-DD\n\n        // Database connection\n        $servername = "your_server";\n        $username = "your_username";\n        $password = "your_password";\n        $dbname = "your_database";\n\n        $conn = new mysqli($servername, $username, $password, $dbname);\n\n        // Check connection\n        if ($conn->connect_error) {\n            die("Connection failed: " . $conn->connect_error);\n        }\n\n        // Prepare and bind\n        $stmt = $conn->prepare("INSERT INTO users (dob) VALUES (?)");\n        $stmt->bind_param("s", $dob);\n\n        // Execute the statement\n        if ($stmt->execute()) {\n            echo "Date of Birth inserted successfully.";\n        } else {\n            echo "Error: " . $stmt->error;\n        }\n\n        // Close connections\n        $stmt->close();\n        $conn->close();\n    } else {\n        echo "Invalid Date of Birth.";\n    }\n}\n?>