public function someAction()\n   {\n       if (!$userAccess) {\n           $this->Flash->error('You do not have access.');\n           return $this->redirect(['action' => 'index']);\n       }\n       // Continue with the rest of the action\n   }