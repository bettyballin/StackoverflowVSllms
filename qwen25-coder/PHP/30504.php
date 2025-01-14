$memcached = new Memcached();\n\n// Configure pool size and servers\n$poolSize = 5; // Example pool size\n\n$servers = [\n    ['127.0.0.1', 11211], // Add your server IP and port\n    // Add more servers if needed\n];\n\nfor ($i = 0; $i < $poolSize; $i++) {\n    foreach ($servers as $server) {\n        list($host, $port) = $server;\n        $memcached->addServer(\n            $host,\n            $port,\n            1,\n            MEMCACHED_PERSISTENT\n        );\n    }\n}\n\n// To get a connection from the pool, typically you would use methods like get/set directly on memcached object\n$value = $memcached->get('your_key');\nif ($value === false) {\n    $value = 'default_value'; // or fetch value from database/source\n    $memcached->set('your_key', $value);\n}