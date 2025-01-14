<?php\n\n/* ./index.php */\n\nfunction Object($object)\n{\n    static $instance = array();\n\n    if (is_file('./' . $object . '.php') === true)\n    {\n        $class = basename($object);\n\n        if (array_key_exists($class, $instance) === false)\n        {\n            if (class_exists($class, false) === false)\n            {\n                require('./' . $object . '.php');\n            }\n\n            $args = func_get_args();\n            array_shift($args); // remove the first argument which is $object\n\n            $reflection = new ReflectionClass($class);\n            $instance[$class] = $reflection->newInstanceArgs($args);\n        }\n\n        return $instance[$class];\n    }\n\n    return false;\n}\n\n/* Usage */\nObject('libraries/DB', 'DATABASE', 'USERNAME', 'PASSWORD')->Query(/* Some Query */);\n\n/* ./libraries/DB.php */\n\nclass DB\n{\n    public function __construct($database, $username, $password, $host = 'localhost', $port = 3306)\n    {\n        // do stuff here\n    }\n\n    public function Query($query)\n    {\n        // Perform query\n    }\n}\n\n?>