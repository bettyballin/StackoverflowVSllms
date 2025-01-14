// Create a memcached instance\n$mc = new Memcached();\n\n// Add server\n$mc->addServer('localhost', 11211);\n\n// Key to cache our data under\n$key = 'cached_data';\n\n// Try and fetch the cached content by key.\n$cachedData = $mc->get($key);\n\nif ($cachedData !== false) {\n    // If we have a cache hit, use it and save some DB calls or heavy computations\n    echo "Cached result: " . $cachedData;\n} else {\n    // Otherwise do our calculations or database query...\n    $result = "Expensive computation...";\n    \n    // Store the data in memcached\n    $mc->set($key, $result, 3600); // Cache for an hour\n\n    echo "Fresh result: " . $result;\n}