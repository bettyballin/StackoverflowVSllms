$insert_query = "INSERT IGNORE INTO your_table (url) VALUES (?)";\n$insert_stmt = $conn->prepare($insert_query);\n$insert_stmt->bind_param("s", $url);\n$insert_stmt->execute();