'Datasources' => [\n       'default' => [\n           'className' => 'Cake\Database\Connection',\n           'driver' => 'Cake\Database\Driver\Mysql',\n           'persistent' => false,\n           'host' => 'localhost',\n           'username' => 'your_db_user',\n           'password' => 'your_db_password',\n           'database' => 'your_db_name',\n           'encoding' => 'utf8',\n           'timezone' => 'UTC',\n           'cacheMetadata' => true,\n           'log' => false,\n           'quoteIdentifiers' => false,\n           'url' => env('DATABASE_URL', null),\n       ],\n   ],