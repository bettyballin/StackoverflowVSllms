public function editAction() {\n    // DO THINGS...\n\n    // Upon failure\n    if ($fail) {\n        $this->_helper->flashMessenger->addMessage('Generic error');\n        $this->_redirector->gotoUrl('/error/index');\n    }\n}