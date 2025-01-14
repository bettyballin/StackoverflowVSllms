<?php\n\nclass DIC {\n    protected static $instances = [];\n    \n    public function register($key, callable $factory) {\n        self::$instances[$key] = $factory;\n    }\n    \n    public function get($key) {\n        if (!isset(self::$instances[$key])) {\n            throw new Exception("Unable to resolve dependency: {$key}");\n        }\n        \n        return call_user_func(self::$instances[$key], $this);\n    }\n}\n\n// Usage\n$dic = new DIC();\n$dic->register('logger', function($dic) { return new Logger(); });\n$logger = $dic->get('logger');