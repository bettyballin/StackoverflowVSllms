// Connect to Memcache once\n$memcache = new Memcache();\nif (!$memcache->connect('127.0.0.1', 11211)) {\n    die('Could not connect to Memcache server.');\n}\n\n// Retrieve multiple items using the same connection\n$rows2 = $memcache->get('therows1');\n$some_var = $memcache->get('some_key');\n\nif ($rows2 == '') {\n    $myfriends = findfriend2();\n    $memcache->set('therows1', $myfriends, 0, 30);\n} else {\n    echo '<pre>';\n    print_r($rows2);\n    echo '</pre>';\n}\n\n// Use the same connection for another item\n$another_var = $memcache->get('another_key');