// In AppController.php\n   public function beforeFilter(Event $event) {\n       parent::beforeFilter($event);\n       $this->response->header('Access-Control-Allow-Origin', '*');\n       $this->response->header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');\n       $this->response->header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');\n   }