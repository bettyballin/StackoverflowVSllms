// Bootstrap.php or similar setup file\n    $translate = new Zend_Translate(\n        array(\n            'adapter' => 'csv',\n            'content' => '/path/to/translations/',\n            'locale'  => 'de' // Default locale\n        )\n    );\n    Zend_Registry::set('Zend_Translate', $translate);