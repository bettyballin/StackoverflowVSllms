$this->getResponse()->setHeader('Content-Type', 'text/html');\n$this->redirector->gotoSimple('manage', 'team', null, array('id' => $teamID));