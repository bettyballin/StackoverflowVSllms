$this->User->find('all', array(\n    'conditions' => array(\n        'User.site_url is NOT NULL'\n    )\n));