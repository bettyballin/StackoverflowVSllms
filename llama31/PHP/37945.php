$username = $this->input->post('username', TRUE);\n$password = $this->input->post('password', TRUE);\n\n// Validate input\nif (!preg_match('/^[a-zA-Z0-9]+$/', $username)) {\n    $this->session->set_flashdata('error', 'Invalid username');\n    redirect('login');\n}