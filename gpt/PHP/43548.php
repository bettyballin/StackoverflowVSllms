<?php\n$memcached = new Memcached();\n$memcached->addServer('localhost', 11211);\n\n$key = 'your_unique_cache_key';\n$data = $memcached->get($key);\n\nif ($data === false) {\n    // Cache miss, perform the database query\n    $data = performDatabaseQuery();\n\n    // Save the result to cache for 10 minutes\n    $memcached->set($key, $data, 600);\n}\n\n// Use $data