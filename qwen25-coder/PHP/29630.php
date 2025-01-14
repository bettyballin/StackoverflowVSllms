function getSqlWithParams($stmt) {\n    $query = $stmt->queryString;\n    $params = [];\n\n    // Extract the original prepared statement parameters.\n    foreach ($stmt as $param => &$value) {\n        if (is_string($param)) {\n            $params[$param] = $value;\n        } else {\n            $types = [\n                PDO::PARAM_BOOL => 'boolean',\n                PDO::PARAM_NULL => 'NULL',\n                PDO::PARAM_INT => 'integer',\n                PDO::PARAM_STR => 'string'\n            ];\n\n            // Default type is string if not specifically set\n            $type = $stmt->getAttribute(PDO::ATTR_EMULATE_PREPARES) ? PDO::PARAM_STR : $value[1];\n\n            $params[$param] = sprintf(':%d', $param);\n        }\n    }\n\n    // Replace the placeholders with the parameters.\n    $matches = [];\n    preg_match_all('/(:\w+)/', $query, $matches);\n\n    foreach ($matches[0] as $match) {\n        if (array_key_exists($match, $params)) {\n            if (is_numeric($params[$match])) {\n                $query = str_replace($match, $params[$match], $query);\n            } else {\n                $query = str_replace($match, "'" . addslashes($params[$match]) . "'", $query);\n            }\n        }\n    }\n\n    return $query;\n}\n\n// Example usage:\ntry {\n    $pdo = new PDO('your_dsn', 'username', 'password');\n    $stmt = $pdo->prepare("SELECT * FROM users WHERE id = :id");\n    $stmt->bindValue(':id', 1, PDO::PARAM_INT);\n    $stmt->execute();\n    \n    echo getSqlWithParams($stmt);\n} catch (PDOException $e) {\n    echo "Error: " . $e->getMessage();\n}