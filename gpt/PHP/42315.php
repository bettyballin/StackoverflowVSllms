$this->db->select('data.title, data.body, data.user_id, IFNULL(users.some_val, "default_value") as some_val');\n$this->db->from('data');\n$this->db->join('users', 'data.user_id = users.user_id', 'left');\n$query = $this->db->get();\n\n$results = $query->result_array();