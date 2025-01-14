$environment = $_SERVER['ENVIRONMENT'] ?? 'production';\n\n   switch ($environment) {\n       case 'development':\n           // Development settings\n           ini_set('display_errors', 1);\n           error_reporting(E_ALL);\n           $dbConfig = ['host' => 'dev-db.example.com'];\n           break;\n       case 'ITS':\n       case 'UAT':\n           // ITS or UAT specific settings\n           $dbConfig = ['host' => 'uat-db.example.com'];\n           break;\n       default:\n       case 'production':\n           // Production settings\n           ini_set('display_errors', 0);\n           error_reporting(0);\n           $dbConfig = ['host' => 'prod-db.example.com'];\n   }