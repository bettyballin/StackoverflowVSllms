amespace App\Controller;\n\nuse App\Controller\AppController;\n\nclass HealthController extends AppController\n{\n    public function index()\n    {\n        $this->set('message', 'Welcome to the Clinical Healthcare Application!');\n    }\n}