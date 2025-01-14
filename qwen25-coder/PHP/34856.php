use Zend\Db\Adapter\Adapter;\nuse Zend\Db\TableGateway\TableGateway;\nuse Zend\Session\Config\SessionConfig;\nuse Zend\Session\Container;\nuse Zend\Session\SaveHandler\DbTableGateway;\nuse Zend\Session\SessionManager;\n\npublic function onBootstrap(MvcEvent $e)\n{\n    // Database configuration\n    $dbParams = [\n        'database' => 'your_database',\n        'username' => 'your_username',\n        'password' => 'your_password',\n        'hostname' => 'localhost',\n    ];\n    \n    $adapter = new Adapter([\n        'driver' => Adapter::DRIVER_PDO_MYSQL,\n        'dsn' => sprintf('mysql:dbname=%s;host=%s', \n            $dbParams['database'], \n            $dbParams['hostname']\n        ),\n        'username' => $dbParams['username'],\n        'password' => $dbParams['password'],\n    ]);\n    \n    $tableGateway = new TableGateway('session_data', $adapter);\n    \n    // Session configuration\n    $config = new SessionConfig();\n    $config->setOptions([\n        'remember_me_seconds' => 2419200,\n        'use_cookies'         => true,\n        'cookie_secure'       => true, // Ensure this is secure in production\n    ]);\n    \n    $manager = new SessionManager($config);\n    \n    $saveHandler = new DbTableGateway();\n    $saveHandler->setTableName('session_data');\n    $saveHandler->setIdCol('id');\n    $saveHandler->setDataCol('data');\n    $saveHandler->setLifetimeCol('lifetime');\n    $saveHandler->setModifiedCol('modified');\n    \n    // Attach the database table gateway to our save handler\n    $saveHandler->setTableGateway($tableGateway);\n    \n    $manager->setSaveHandler($saveHandler);\n    \n    SessionManager::setDefaultManager($manager);\n}