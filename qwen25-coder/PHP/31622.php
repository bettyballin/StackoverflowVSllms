<?php\n// Assuming $userId holds the current user's ID and $mysqli is your database connection\n\n// Get user join date\n$userQuery = "SELECT join_date FROM users WHERE id = ?";\n$stmtUser = $mysqli->prepare($userQuery);\n$stmtUser->bind_param("i", $userId);\n$stmtUser->execute();\n$resultUser = $stmtUser->get_result();\n$userRow = $resultUser->fetch_assoc();\n$joinDate = $userRow['join_date'];\n\n// Get the posts with dates since the user joined\n$postQuery = "SELECT DATE_FORMAT(post_date, '%Y-%m') AS month_year \n              FROM posts WHERE user_id = ? AND post_date >= ?\n              GROUP BY month_year\n              ORDER BY month_year DESC";\n$stmtPost = $mysqli->prepare($postQuery);\n$stmtPost->bind_param("is", $userId, $joinDate);\n$stmtPost->execute();\n$resultPost = $stmtPost->get_result();\n\n// Display the results as links\necho "<ul>";\nwhile ($row = $resultPost->fetch_assoc()) {\n    $formattedMonthYear = date('F Y', strtotime($row['month_year']));\n    echo "<li><a href='?month={$row['month_year']}'>$formattedMonthYear</a></li>";\n}\necho "</ul>";\n\n$stmtUser->close();\n$stmtPost->close();\n?>