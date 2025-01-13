$link = new mysqli("hostname", "username", "password", "database");\n\nif ($link->connect_error) {\n    die("Connection failed: " . $link->connect_error);\n}\n\n// Outer statement\nif ($stmt = $link->prepare("SELECT item, id FROM data WHERE id = ?")) {\n    $stmt->bind_param("i", $id);\n    $stmt->execute();\n    $stmt->bind_result($item, $itemID);\n    \n    while ($stmt->fetch()) {\n        // Perform calculations or other code\n        $itemSummary = $item + $magic;\n\n        // Inner statement\n        if ($stmt2 = $link->prepare("INSERT INTO summaries (itemID, summary) VALUES (?, ?)")) {\n            $stmt2->bind_param("is", $itemID, $itemSummary);\n            $stmt2->execute();\n            $stmt2->close();\n        } else {\n            // Handle error for inner statement\n            printf("Error: %s.\n", $link->error);\n        }\n    }\n    \n    $stmt->close();\n} else {\n    // Handle error for outer statement\n    printf("Error: %s.\n", $link->error);\n}\n\n$link->close();