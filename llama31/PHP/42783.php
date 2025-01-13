// Simple caching example using PHP's built-in file-based caching\nfunction cache_get($key) {\n    $cache_file = 'cache/' . $key . '.cache';\n    if (file_exists($cache_file)) {\n        return unserialize(file_get_contents($cache_file));\n    }\n    return null;\n}\n\nfunction cache_set($key, $value) {\n    $cache_file = 'cache/' . $key . '.cache';\n    file_put_contents($cache_file, serialize($value));\n}\n\n// Usage example:\n$data = cache_get('my_data');\nif (!$data) {\n    $data = expensive_database_query();\n    cache_set('my_data', $data);\n}