// Example of a simple Singleton pattern in PHP\nclass Singleton {\n    private static $instance;\n\n    private function __construct() {}\n\n    public static function getInstance() {\n        if (!self::$instance) {\n            self::$instance = new self();\n        }\n        return self::$instance;\n    }\n}