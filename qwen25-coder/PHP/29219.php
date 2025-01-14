class Signup extends CI_Controller {\n       public function index() {\n           $this->load->model('Account_model');\n           \n           // Assuming you get the form data through POST method\n           $account_data = $this->input->post('account_info');\n           $user_data = $this->input->post('user_info');\n           \n           if ($this->Account_model->create_account($account_data, $user_data)) {\n               redirect('/members/account');\n           } else {\n               // Handle error\n           }\n       }\n   }\n\n   class Members extends CI_Controller {\n       public function account() {\n           $this->load->model('Account_model');\n           \n           // Load the account details and user data\n           $account_id = 1; // Example ID, replace with actual logic to get current account ID\n           $data['account'] = $this->Account_model->get_account_details($account_id);\n           $data['users'] = $this->Account_model->get_users_by_account($account_id);\n           \n           $this->load->view('members/account', $data);\n       }\n\n       public function update_account() {\n           $this->load->model('Account_model');\n           \n           // Assuming you get the form data through POST method\n           $account_id = 1; // Example ID, replace with actual logic to get current account ID\n           $data = $this->input->post('account_info');\n           \n           if ($this->Account_model->update_account($account_id, $data)) {\n               redirect('/members/account');\n           } else {\n               // Handle error\n           }\n       }\n   }