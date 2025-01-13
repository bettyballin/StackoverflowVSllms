use Illuminate\Database\Capsule\Manager as Capsule;\n\n    $capsule = new Capsule;\n    $capsule->addConnection([\n        'driver'    => 'pgsql',\n        'host'      => 'your_host',\n        'database'  => 'your_db',\n        'username'  => 'your_user',\n        'password'  => 'your_pass',\n        'charset'   => 'utf8',\n        'collation' => 'utf8_unicode_ci',\n        'prefix'    => '',\n    ]);\n\n    $capsule->setAsGlobal();\n    $capsule->bootEloquent();