class TypesController extends AppController {\n    public function index() {\n        $types = $this->Type->find('all');\n        $this->set('types', $types);\n    }\n}