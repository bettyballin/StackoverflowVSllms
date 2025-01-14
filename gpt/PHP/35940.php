// src/Controller/PeopleController.php\nnamespace App\Controller;\n\nuse App\Controller\AppController;\n\nclass PeopleController extends AppController\n{\n    public function index()\n    {\n        $query = $this->People->find();\n        \n        if ($this->request->is('post')) {\n            $search = $this->request->getData('search');\n            // Using LIKE for a wildcard search\n            $query->where(['surname LIKE' => '%' . $search . '%']);\n        }\n\n        $people = $this->paginate($query);\n        $this->set(compact('people'));\n    }\n}