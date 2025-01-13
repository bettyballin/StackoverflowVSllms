<?php\nnamespace App\Controller;\n\nuse App\Controller\AppController;\n\nclass ArticlesController extends AppController\n{\n    public function index()\n    {\n        // Fetch data from the database\n        $articles = $this->Articles->find('all');\n        $this->set(compact('articles'));\n    }\n\n    public function view($id = null)\n    {\n        $article = $this->Articles->get($id);\n        $this->set(compact('article'));\n    }\n}\n?>