class DATABASE_CONFIG {\n    var $default = array(\n        'driver' => 'mysql',\n        'connect' => 'mysql_connect',\n        'persistent' => false,\n        'host' => 'localhost:/Applications/MAMP/tmp/mysql/mysql.sock', // note the localhost: prefix\n        'login' => 'my_user',\n        'password' => 'my_pass',\n        'database' => 'blog',\n        'prefix' => '',\n    );\n}