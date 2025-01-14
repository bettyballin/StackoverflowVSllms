function preparedQueryDebug($sql, $params) {\n    // Split the sql statement by question marks (ignoring escaped ones)\n    $pieces = preg_split('/(?<!\\\\)\?/', $sql);\n\n    // Start with the first part of the query\n    $formattedSql = array_shift($pieces);\n\n    foreach ($params as $param) {\n        if (is_null($param)) {\n            // If the parameter is null, use NULL in SQL\n            $bindParam = 'NULL';\n        } elseif (!is_numeric($param)) {\n            // If it's not numeric, add quotes around it\n            // Also escape single quotes in the string\n            $bindParam = "'" . str_replace("'", "''", $param) . "'";\n        } else {\n            // Leave numbers as is\n            $bindParam = $param;\n        }\n        \n        // Append the parameter and the next part of the query\n        $formattedSql .= $bindParam . array_shift($pieces);\n    }\n\n    return $formattedSql;\n}\n\n$id = 1;\n$baz = "O'Reilly's something";\n\n$sql = "SELECT foo FROM bar WHERE id=? AND baz=?";\necho preparedQueryDebug($sql, [$id, $baz]);