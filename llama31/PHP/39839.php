// Home.php\nclass Home extends MY_Controller {\n    public function index() {\n        $this->data['feature'] = $this->load->view('widgets/home_feature','',true);\n        $this->data['login'] = $this->load->view('widgets/login','',true);\n        // ... load other widgets ...\n        $this->load->vars($this->data);\n        $this->load->view('pages/home_view');\n    }\n}