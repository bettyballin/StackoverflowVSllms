$form->addElement(\n    'select',\n    'salutation',\n    array(\n        'required' => true,\n        'multiOptions' => array( // Change 'options' to 'multiOptions'\n            'Mr.' => 'Mr.',\n            'Mrs.' => 'Mrs.',\n            'Ms.' => 'Ms.',\n        ),\n    )\n);