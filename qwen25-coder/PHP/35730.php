class DATABASE_CONFIG {\n    public $default = array(\n        'datasource' => 'Database/Mysql',\n        'persistent' => false,\n        'host'       => 'localhost', // Use localhost, not the socket path here\n        'port'       => '8889',      // Default MAMP MySQL port\n        'login'      => 'my_user',\n        'password'   => 'my_pass',\n        'database'   => 'blog',\n        'unix_socket'=> '/Applications/MAMP/tmp/mysql/mysql.sock', // Specify the socket path here\n        'prefix'     => '',\n    );\n}