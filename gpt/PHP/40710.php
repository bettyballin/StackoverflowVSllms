// config.php\n   return [\n       'dbname' => 'my_database',\n       'hostname' => 'localhost',\n       'username' => 'user',\n       'password' => 'password',\n   ];\n\n   // usage\n   $config = include('config.php');\n   $dbname = $config['dbname'];