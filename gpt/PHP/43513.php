<?php\nclass Auth {\n    protected $CI;\n\n    public function __construct() {\n        $this->CI =& get_instance();\n        $this->CI->load->library('session');\n        $this->CI->load->model('user_model');\n    }\n\n    public function login($username, $password) {\n        $user = $this->CI->user_model->validate_user($username, $password);\n        if ($user) {\n            $this->CI->session->set_userdata('user_id', $user['id']);\n            return true;\n        }\n        return false;\n    }\n\n    public function logout() {\n        $this->CI->session->unset_userdata('user_id');\n    }\n\n    public function is_logged_in() {\n        return $this->CI->session->userdata('user_id') !== NULL;\n    }\n}\n?>