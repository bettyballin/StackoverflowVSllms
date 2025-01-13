<?php\n// Database connection\n$mysqli = new mysqli("host", "username", "password", "database");\n\n// Check connection\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n// Query to get event data\n$query = "SELECT e.primary AS username, e.eventDate \n          FROM eventcal e \n          JOIN users u ON e.primary = u.username \n          WHERE MONTH(e.eventDate) BETWEEN 8 AND 12 \n          OR MONTH(e.eventDate) BETWEEN 1 AND 5";\n\n$result = $mysqli->query($query);\n\n$user_data = [];\nwhile ($row = $result->fetch_assoc()) {\n    $username = $row['username'];\n    $eventDate = $row['eventDate'];\n    $month = date('m', strtotime($eventDate));\n    $dayOfWeek = date('N', strtotime($eventDate)); // 1 (for Monday) through 7 (for Sunday)\n\n    $isWeekend = ($dayOfWeek >= 6);\n\n    if (!isset($user_data[$username])) {\n        $user_data[$username] = ['total_weekdays' => 0, 'total_weekends' => 0, 'months' => []];\n    }\n\n    if (!isset($user_data[$username]['months'][$month])) {\n        $user_data[$username]['months'][$month] = ['weekdays' => 0, 'weekends' => 0];\n    }\n\n    if ($isWeekend) {\n        $user_data[$username]['total_weekends']++;\n        $user_data[$username]['months'][$month]['weekends']++;\n    } else {\n        $user_data[$username]['total_weekdays']++;\n        $user_data[$username]['months'][$month]['weekdays']++;\n    }\n}\n\n// Output results in an HTML table\necho "<table border='1'>";\necho "<tr><th>Username</th><th>Month</th><th>Weekdays</th><th>Weekends</th><th>Total Weekdays</th><th>Total Weekends</th></tr>";\n\nforeach ($user_data as $username => $data) {\n    foreach ($data['months'] as $month => $counts) {\n        echo "<tr>";\n        echo "<td>$username</td>";\n        echo "<td>$month</td>";\n        echo "<td>{$counts['weekdays']}</td>";\n        echo "<td>{$counts['weekends']}</td>";\n        echo "<td>{$data['total_weekdays']}</td>";\n        echo "<td>{$data['total_weekends']}</td>";\n        echo "</tr>";\n    }\n}\n\necho "</table>";\n\n$mysqli->close();\n?>