function email_check($str)\n{\n    $query = $this->db->query("SELECT email FROM mytable WHERE email = ?", array($str));\n    $num = $query->num_rows();\n\n    if ($num > 0)\n    {\n        $this->validation->set_message('username_check', 'Email already in use');\n        return FALSE;\n    }\n    else\n    {\n        return TRUE;\n    }\n}