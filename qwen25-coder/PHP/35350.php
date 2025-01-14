$mysqli = new mysqli("localhost", "username", "password", "database");\n\nif ($stmt = $mysqli->prepare("CALL your_stored_procedure()")) {\n    $stmt->execute();\n    \n    do {\n        if ($result = $stmt->get_result()) {\n            while ($row = $result->fetch_assoc()) {\n                // Process each row\n                echo print_r($row, true);\n            }\n            $result->close();\n        }\n    } while ($mysqli->next_result());\n\n    $stmt->close();\n}\n\n$mysqli->close();