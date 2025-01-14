<?php   \nclass User extends CI_Controller {\n\n   public function __construct() {\n      parent::__construct();\n   }\n   \n   public function index($username = FALSE) {\n      if ($username == FALSE) {\n         // Load default profile page or redirect\n         show_404();\n      } else {\n         // Access the database and get info for $username\n         $data['user_info'] = $this->YourModel->get_user_by_username($username);\n\n         if (empty($data['user_info'])) {\n            show_404();\n         }\n\n         // Load profile page with said info\n         $this->load->view('profile', $data);\n      }\n   }\n}