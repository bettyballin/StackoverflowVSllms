class Admin extends CI_Controller {\n       public function index() {\n           $this->load->model('blog_model');\n           $data['posts'] = $this->blog_model->get_posts();\n           $this->load->view('admin/index', $data);\n       }\n\n       public function create_post() {\n           // Assume you have a form in the view that posts here\n           $post_data = array(\n               'title' => $this->input->post('title'),\n               'content' => $this->input->post('content')\n           );\n           \n           $this->load->model('blog_model');\n           $success = $this->blog_model->add_post($post_data);\n           \n           if ($success) {\n               redirect('admin/index'); // Redirect to the blog list\n           } else {\n               show_error('Failed to create post.');\n           }\n       }\n\n       // Similarly, you would have methods for edit and delete functionalities.\n   }