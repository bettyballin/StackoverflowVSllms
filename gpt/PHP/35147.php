class Logger {\n    public static function logEntry($methodName) {\n        echo "Entering: $methodName\n";\n    }\n\n    public static function logExit($methodName) {\n        echo "Exiting: $methodName\n";\n    }\n\n    public static function info($message) {\n        echo "Info: $message\n";\n    }\n}\n\nclass TestClass {\n    public function __call($name, $arguments) {\n        Logger::logEntry($name);\n        Logger::info('Parameters: ' . json_encode($arguments));\n\n        // Call the actual method\n        $result = call_user_func_array([$this, "actual_$name"], $arguments);\n\n        Logger::logExit($name);\n        return $result;\n    }\n\n    // Example of actual method that will be called\n    public function actual_tester($arg) {\n        // Do some stuff...\n        return "Result of tester with arg: $arg";\n    }\n}\n\n// Usage\n$test = new TestClass();\necho $test->tester('example argument');