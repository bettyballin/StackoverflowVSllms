function extracting_comments($table, $fields, $condition, $order, $limit) {\n    $query = "SELECT " . $fields . "\n              FROM " . $table . "\n              WHERE " . $condition . "\n              ORDER BY " . $order . "\n              LIMIT " . $limit;\n\n    if ($stmt = $this->conn->prepare($query)) {\n        $stmt->execute();\n        $row = array_pad(array(), $stmt->field_count, '');\n        $params = array();\n        \n        foreach ($row as $k => $v) {\n            $params[] = &$row[$k];\n        }\n        \n        call_user_func_array(array($stmt, 'bind_result'), $params);\n        $results = [];\n        \n        while ($stmt->fetch()) {\n            $atul = [];\n            foreach ($row as $b => $elem) {\n                $atul[$b] = $row[$b];\n            }\n            $results[] = $atul;\n        }\n        \n        $stmt->close();\n        return $results;\n    } else {\n        // Handle query preparation failure\n        return null;\n    }\n}