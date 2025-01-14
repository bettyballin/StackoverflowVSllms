function get_recent_activities() {\n    $query = "SELECT * FROM activities ORDER BY created_at DESC LIMIT 10";\n    $result = executeQuery($query);\n\n    if ($result === false) {\n        return "Failed to retrieve recent activities.";\n    }\n    return $result;\n}\n\nfunction get_user_by_id($user_id) {\n    $query = "SELECT * FROM users WHERE id = :id";\n    $params = ['id' => $user_id];\n    $result = executeQuery($query, $params);\n\n    if ($result === false) {\n        return "Failed to retrieve user.";\n    }\n    return $result;\n}