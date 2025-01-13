<?php\n// Create a Memcached instance\n$memcached = new Memcached();\n$memcached->addServer('127.0.0.1', 11211);\n\n// Define a unique key for the cached data\n$cacheKey = 'unique_data_key';\n\n// Check if data is in cache\n$data = $memcached->get($cacheKey);\n\nif ($data === false) {\n    // Data not found in cache, fetch from database or other source\n    $data = fetchDataFromDatabase(); // Replace with your data fetching logic\n\n    // Store data in cache for future requests\n    $memcached->set($cacheKey, $data, 3600); // Cache for 1 hour\n}\n\n// Use the cached data\necho $data;\n\n// Function to simulate data fetching from a database\nfunction fetchDataFromDatabase() {\n    // Simulate a slow database query\n    sleep(2);\n    return "Fetched data from database";\n}\n?>