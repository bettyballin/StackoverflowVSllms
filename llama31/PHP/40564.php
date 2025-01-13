public function login()\n{\n    // ...\n    if ($this->input->post('remember_me')) {\n        $token = bin2hex(random_bytes(32));\n        $this->db->where('email', $this->input->post('email'));\n        $this->db->update('users', array('remember_token' => $token));\n        $this->input->set_cookie('remember_me', $token, 86400 * 30); // 30 days\n    }\n    // ...\n}