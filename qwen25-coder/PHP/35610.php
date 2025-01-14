function get_total_adults() {\n    try {\n        $pdo = new PDO("mysql:host=your_host;dbname=your_database", "your_username", "your_password");\n        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n        $sql = "SELECT SUM(number_adults_attending) as number_of_adults FROM is_nfo_rsvp";\n        $stmt = $pdo->query($sql);\n        $array = $stmt->fetch(PDO::FETCH_ASSOC);\n\n        return $array['number_of_adults'];\n    } catch (PDOException $e) {\n        die("Connection failed: " . $e->getMessage());\n    }\n}