public function deletepostAction() {\n    $request = $this->getRequest();\n    $postData = $request->getRawPost();\n    $formUrl = $postData['formUrl'];\n    // ...\n}