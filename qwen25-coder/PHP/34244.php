// Now create your other controllers by extending Controller_Base\nclass Controller_Welcome extends Controller_Base {\n\n    public function action_index() {\n        // Accessing session data\n        $user_id = $this->session->get('user_id');\n\n        // Performing a database query\n        $query = DB::select()->from('users')->where('id', '=', $user_id)->execute();\n        $user_data = $query->as_array();\n\n        // You can use $user_data as needed in your view or logic\n    }\n}