<?php\nfunction getConfigurations() {\n    // Connect to the database\n    $mysqli = new mysqli("hostname", "username", "password", "database");\n\n    // Check connection\n    if ($mysqli->connect_error) {\n        die("Connection failed: " . $mysqli->connect_error);\n    }\n\n    // Perform a single query to get all configurations\n    $sql = "SELECT config_key, config_value FROM configurations";\n    $result = $mysqli->query($sql);\n\n    // Check if query was successful\n    if ($result->num_rows > 0) {\n        // Store configurations in an associative array\n        $configurations = [];\n        while ($row = $result->fetch_assoc()) {\n            $configurations[$row['config_key']] = $row['config_value'];\n        }\n        return $configurations;\n    } else {\n        return [];\n    }\n\n    // Close the database connection\n    $mysqli->close();\n}\n\n// Usage example\n$configs = getConfigurations();\n$resultsPerPage = $configs['results_per_page'];\n$columnLayout = $configs['column_layout'];\n?>