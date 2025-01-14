<?php\ndefined('BASEPATH') OR exit('No direct script access allowed');\n\nclass Users extends CI_Controller {\n\n    public function index() {\n        // Check if user is admin or manager\n        if ($this->user_model->has_role($this->session->userdata('user_id'), ['admin', 'manager'])) {\n            $data['users'] = $this->user_model->get_all_users();\n            $this->load->view('users/index', $data);\n        } else {\n            show_error('You do not have permission to access this page.');\n        }\n    }\n\n    public function create() {\n        // Check if user is admin\n        if ($this->user_model->has_role($this->session->userdata('user_id'), ['admin'])) {\n            if ($_SERVER['REQUEST_METHOD'] === 'POST') {\n                $this->user_model->create_user();\n                redirect('/users');\n            } else {\n                $this->load->view('users/create');\n            }\n        } else {\n            show_error('You do not have permission to access this page.');\n        }\n    }\n}