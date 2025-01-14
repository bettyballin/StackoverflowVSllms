class User extends CI_Controller {\n\n    public function profile() {\n        // Load necessary models or libraries if any\n        // Fetch user data\n        $data['user'] = $this->get_user_data();  // Assuming a method to fetch user data\n\n        // Load the main layout with the user profile box included\n        $this->load->view('profile_layout', $data);\n    }\n\n    public function ajax_profile() {\n        // Fetch user data\n        $data['user'] = $this->get_user_data();  // Assuming a method to fetch user data\n\n        // Load only the user profile box for AJAX call\n        $this->load->view('user_profile_box', $data);\n    }\n\n    private function get_user_data() {\n        // Dummy method. Replace with actual logic to retrieve user data\n        return ['name' => 'John Doe', 'email' => 'john.doe@example.com'];\n    }\n}