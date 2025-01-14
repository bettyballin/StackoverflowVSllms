// Assuming $result is your MySQL query result resource or PDO statement object\n\nif ($mysqli->more_results()) {\n    $mysqli->next_result();\n}\n\n$result = $mysqli->query("YOUR QUERY HERE");\n\n$data = []; // Array to hold the results\n\nwhile ($row = $result->fetch_assoc()) {\n    $data[] = $row;\n}\n\n$jsonString = json_encode($data); // Convert array of results to JSON string\n\nfile_put_contents('cache_file.json', $jsonString); // Write JSON string to file