// application/libraries/Auth.php\nclass Auth {\n    public function __construct() {\n        $this->load->model('your_auth_model');\n    }\n\n    public function authenticate() {\n        // Call your authentication model's method here\n        return $this->your_auth_model->authenticate();\n    }\n}