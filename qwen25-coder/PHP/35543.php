// Example Doctrine configuration array\n  return [\n      'doctrine' => [\n          'connection' => [\n              'orm_default' => [\n                  'driverClass' => PDOConnection::class,\n                  'params' => [\n                      'host' => 'localhost',\n                      'port' => '5432',\n                      'user' => 'db_user',\n                      'password' => 'db_password',\n                      'dbname' => 'my_database',\n                      'charset'    => 'utf8mb4',\n                  ],\n              ],\n          ],\n      ],\n  ];