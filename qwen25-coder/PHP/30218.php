public function login()\n{\n    $this->load->model('user_model');\n    $email = $this->input->post('email');\n    $password = $this->input->post('password');\n    $remember_me = $this->input->post('remember_me');\n\n    $user_data = $this->user_model->login($email, md5($password)); // Assuming passwords are hashed with MD5 for simplicity\n\n    if ($user_data) {\n        $data = array(\n            'user_id' => $user_data['id'],\n            'username' => $user_data['username'],\n            'logged_in' => TRUE\n        );\n\n        $this->session->set_userdata($data);\n\n        // Set a cookie if "Remember Me" was checked\n        if ($remember_me) {\n            $cookie = array(\n                'name'   => 'auth',\n                'value'  => json_encode(array('email' => $email, 'password' => md5($password))),\n                'expire' => '86400', // 1 day expiration\n                'secure' => TRUE,\n                'httponly' => TRUE\n            );\n            $this->input->set_cookie($cookie);\n        }\n\n        redirect('dashboard');\n    } else {\n        $this->session->set_flashdata('error', 'Invalid email or password.');\n        redirect('login');\n    }\n}