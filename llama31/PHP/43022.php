function view($id = null) {\n    $this->Guitar->id = $id;\n    $guitar = $this->Guitar->read();\n    $this->set('guitar', $guitar);\n    $this->pageTitle = $guitar['Guitar']['Name'];\n}