<?php\n$page = isset($_GET['page']) ? (int)$_GET['page'] : 1;\n$resultsPerPage = 10;\n\n// Connect to your database here...\n$dbConnection = mysqli_connect("host", "user", "password", "database");\nif (!$dbConnection) die("Database connection failed");\n\n$offset = ($page - 1) * $resultsPerPage;\n\n$query = "SELECT * FROM your_table_name ORDER BY some_column LIMIT ? OFFSET ?";\n$stmt = $dbConnection->prepare($query);\n$stmt->bind_param("ii", $resultsPerPage, $offset);\n$stmt->execute();\n$result = $stmt->get_result();\n\necho "<table border='1'>\n<tr>\n<th>Column 1</th>\n<th>Column 2</th>\n<!-- Add more headers as necessary -->\n</tr>";\n\nwhile ($row = $result->fetch_assoc()) {\n    echo "<tr>";\n    echo "<td>" . htmlspecialchars($row['column1']) . "</td>"; // Avoid XSS\n    echo "<td>" . htmlspecialchars($row['column2']) . "</td>"; // Avoid XSS\n    // Add more cells as necessary\n    echo "</tr>";\n}\n\necho "</table>";\n\n$totalResultsQuery = "SELECT count(*) as total FROM your_table_name";\n$totalResultStmt = $dbConnection->query($totalResultsQuery);\n$totalRow = $totalResultStmt->fetch_assoc();\n$totalResults = $totalRow['total'];\n$totalPages = ceil($totalResults / $resultsPerPage);\n\necho "<div style='text-align:center;'>";\nfor ($i = 1; $i <= $totalPages; $i++) {\n    if ($i == $page) {\n        echo "$i ";\n    } else {\n        echo "<a href='?page=$i'>$i</a> ";\n    }\n}\necho "</div>";\n\n$stmt->close();\n$dbConnection->close();\n?>