// Assuming $db is your SQLite database connection and $results contains the JSON data\nforeach ($results as $printresults) {\n    $title = $printresults['title'];\n    $path = $printresults['path'];\n    $visitors = $printresults['visitors'];\n    $time = time(); // Assuming you're using the current timestamp\n\n    // Prepare the SQL statement\n    $stmt = $db->prepare("\n        INSERT INTO topten (title, path, visitors, time)\n        VALUES (:title, :path, :visitors, :time)\n        ON CONFLICT(title) DO UPDATE SET\n            visitors = visitors + excluded.visitors,\n            path = excluded.path,\n            time = excluded.time\n    ");\n\n    // Bind parameters\n    $stmt->bindValue(':title', $title, SQLITE3_TEXT);\n    $stmt->bindValue(':path', $path, SQLITE3_TEXT);\n    $stmt->bindValue(':visitors', $visitors, SQLITE3_INTEGER);\n    $stmt->bindValue(':time', $time, SQLITE3_INTEGER);\n\n    // Execute the statement\n    $stmt->execute();\n}