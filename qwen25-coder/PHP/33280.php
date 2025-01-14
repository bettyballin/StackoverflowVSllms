// In your AppController.php or specific controller\npublic function initialize()\n{\n    parent::initialize();\n\n    // Load component with default settings\n    $this->loadComponent('RequestHandler');\n    $this->loadComponent('Flash');\n\n    // Check session\n    debug($this->request->getSession()->read()); // Use this to see if session is loaded correctly\n\n    $this->Auth->allow(['index', 'login']); // Ensure these are properly set in your controller\n}