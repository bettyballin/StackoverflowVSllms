public function deletepostAction() {\n    $postParams = $this->getRequest()->getPost();\n    print_r($postParams);\n    die;\n}