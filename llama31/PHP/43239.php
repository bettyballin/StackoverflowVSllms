$redis = new Redis();\n$redis->connect('localhost');\n\n$obj = new stdClass();\n$obj->foo = 'bar';\n\n$redis->set('my_object', $obj);\n\n// Later...\n$obj = $redis->get('my_object');