public function someAction()\n   {\n       if (!$userAccess) {\n           $this->Flash->error('You do not have access.');\n           return $this->response->withStatus(403)->withStringBody('Forbidden');\n       }\n       // Continue with the rest of the action\n   }