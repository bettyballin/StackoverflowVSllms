<?php\nuse Redis;\n\n// Connect to Redis\n$redis = new Redis();\n$redis->connect('localhost', 6379);\n\n// Cache a query result for 1 hour\n$result = $redis->get('query_result');\nif (!$result) {\n    // Run the query and cache the result\n    $result = db_query('SELECT * FROM users');\n    $redis->set('query_result', $result);\n    $redis->expire('query_result', 3600); // 1 hour\n}\n\n// Use the cached result\nprint_r($result);