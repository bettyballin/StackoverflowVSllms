public function indexAction() {\n    $flashMessenger = $this->_helper->getHelper('FlashMessenger');\n\n    if ($flashMessenger->hasMessages()) {\n        $this->view->errorMessage = $flashMessenger->getMessages();\n    }\n}