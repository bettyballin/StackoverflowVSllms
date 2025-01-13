class News extends CI_Controller {\n\n    public function __construct() {\n        parent::__construct();\n        $this->load->model('news_model');\n    }\n\n    public function create() {\n        $data = [\n            'title' => $this->input->post('title'),\n            'content' => $this->input->post('content')\n        ];\n        $this->news_model->insert_news($data);\n    }\n\n    public function update($id) {\n        $data = [\n            'title' => $this->input->post('title'),\n            'content' => $this->input->post('content')\n        ];\n        $this->news_model->update_news($id, $data);\n    }\n\n    public function delete($id) {\n        $this->news_model->delete_news($id);\n    }\n}