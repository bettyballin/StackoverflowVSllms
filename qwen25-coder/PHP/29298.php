<?php\n$userData = array(\n    // Example data format\n    array(\n        'User' => array('id' => 1),\n        'Sites' => array(array('id' => 2), array('id' => 3))\n    ),\n    array(\n        'User' => array('id' => 2),\n        'Sites' => array(array('id' => 4))\n    )\n);\n\n$this->User->saveAll($userData, array('deep' => true));\n?>