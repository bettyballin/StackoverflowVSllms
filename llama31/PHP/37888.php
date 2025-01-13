// app/Controller/UsersController.php\nclass UsersController extends AppController {\n    public function index() {\n        $users = $this->User->find('all');\n        $this->set('users', $users);\n    }\n\n    public function view($id = null) {\n        $user = $this->User->findById($id);\n        $this->set('user', $user);\n    }\n}