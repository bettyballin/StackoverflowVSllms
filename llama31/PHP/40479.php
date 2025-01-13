// src/Controller/UsersController.php\n\nnamespace App\Controller;\n\nuse App\Model\Entity\User;\nuse Cake\ORM\TableRegistry;\n\nclass UsersController extends AppController\n{\n    public function index()\n    {\n        $users = TableRegistry::getTableLocator()->get('Users')->find();\n        $this->set(compact('users'));\n    }\n\n    public function view($id)\n    {\n        $user = TableRegistry::getTableLocator()->get('Users')->get($id);\n        $this->set(compact('user'));\n    }\n}