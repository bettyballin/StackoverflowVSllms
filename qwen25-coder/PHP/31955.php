$this->db->select('data.*, COALESCE(users.some_val, "default_value") as some_val');\n$this->db->from('data');\n$this->db->join('users', 'data.user_id = users.user_id', 'left');\n$query = $this->db->get();\n\n$results = [];\nforeach ($query->result_array() as $row) {\n    // The COALESCE function in the query ensures that if some_val is NULL, "default_value" is used instead\n    $results[] = [\n        'title' => $row['title'],\n        'body' => $row['body'],\n        'user_id' => $row['user_id'],\n        'some_val' => $row['some_val'], // This will be the default value if user does not exist in users table\n    ];\n}\n\nprint_r($results);