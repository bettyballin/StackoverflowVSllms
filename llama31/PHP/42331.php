if ($this->Auth->password($this->data['User']['password']) != \n    $this->Auth->password($this->data['User']['confirm_password'])) {\n    // passwords do not match\n}