public function action1Action()\n{\n    if (!$this->loggedIn || !$this->athlete) {\n        $this->_redirect('index');\n    }\n    if (!$this->_request->isXmlHttpRequest()) {\n        // The request was NOT made with JS XmlHttpRequest\n        die;\n    }\n    // Do some administration\n    // (removed to make this easier in this example)\n\n    $pb = new Zend_Form_Element_Text('PB');\n    $pb->setLabel('PB:')\n          ->addValidator('StringLength', false, array(0,20))\n          ->setRequired(false);\n    $renderText = $pb->render();\n\n    $this->_helper->json($renderText);\n}