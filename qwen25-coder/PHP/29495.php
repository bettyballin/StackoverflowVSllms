<?php\n// Database connection parameters\n$servername = "localhost";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Calculate the date one day ago from today\n$oneDayAgo = date('Y-m-d', strtotime('-1 day'));\n\n// SQL query to select records where Date is one day old\n$sql = "SELECT email FROM your_table WHERE DATE(Date) = '$oneDayAgo'";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    // Collect all emails\n    $emails = [];\n    while($row = $result->fetch_assoc()) {\n        $emails[] = $row['email'];\n    }\n\n    // Prepare the email content\n    $to = implode(',', $emails);\n    $subject = "Your Daily Update";\n    $message = "Hello, this is your daily update.";\n    $headers = "From: noreply@example.com";\n\n    // Send the email\n    if(mail($to, $subject, $message, $headers)) {\n        echo "Emails sent successfully!";\n    } else {\n        echo "Failed to send emails.";\n    }\n} else {\n    echo "No records found for the specified date.";\n}\n\n// Close the connection\n$conn->close();\n?>