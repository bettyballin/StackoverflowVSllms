$this->load->library('auth');\n\n     if($this->auth->login('username', 'password'))\n     {\n         // Redirect them to the dashboard or something\n         redirect('/', 'refresh');\n     }