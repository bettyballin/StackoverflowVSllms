function __construct()\n{\n    require 'config.php';\n    \n    // Define your config as an associative array\n    $configArray = [\n        'adminEmail' => 'user@domain.tld'\n    ];\n    \n    // Convert the array to an object\n    $this->config = (object) $configArray;\n}