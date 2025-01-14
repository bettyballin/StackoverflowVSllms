public function queryPrepared($sql, $params = [], $types = '', $multi = false) {\n    // Prepare the SQL statement\n    if ($stmt = $this->db->prepare($sql)) {\n        // Bind parameters to the statement (if any)\n        if (!empty($params) && !empty($types)) {\n            $params_array = array_merge([$stmt, $types], $params);\n            call_user_func_array('mysqli_stmt_bind_param', $params_array);\n        }\n\n        // Execute the statement\n        $stmt->execute();\n\n        // Check for SELECT query to fetch results\n        if (stripos(trim($sql), 'select') === 0) {\n            $result = $stmt->get_result();\n            \n            if ($multi) {\n                $objects = [];\n                while ($row = $result->fetch_object()) {\n                    $objects[] = $row;\n                }\n                return $objects;\n            } else {\n                return $result->fetch_object() ?? null;\n            }\n        }\n\n        // For INSERT, UPDATE, DELETE\n        return true;  // or fetch the affected rows if needed with $stmt->affected_rows\n\n    } else {\n        error_log($this->db->error);  // Log the error instead of showing it directly\n        return false;\n    }\n\n    // Close the statement\n    $stmt->close();\n}