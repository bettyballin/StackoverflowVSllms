$config = array(\n    'name'           => 'sessions', // table name\n    'primary'        => 'id',       // primary key\n    'modifiedColumn' => 'modified', // column to track last modification\n    'dataColumn'     => 'data',     // column to store session data\n    'lifetimeColumn' => 'lifetime'  // column to store session lifetime\n);\n\nZend_Session::setSaveHandler(new Zend_Session_SaveHandler_DbTable($config));\n\n// Create the table\n$db = Zend_Db::factory('Pdo_Mysql', array(\n    'host'     => 'localhost',\n    'username' => 'username',\n    'password' => 'password',\n    'dbname'   => 'database'\n));\n\n$db->query('\n    CREATE TABLE sessions (\n        id CHAR(32) PRIMARY KEY,\n        modified INT,\n        lifetime INT,\n        data TEXT\n    );\n');