abstract class ParentObj {\n    public function __construct() {\n        // Initialization code\n    }\n\n    public static function factory() {\n        $calledClass = get_called_class();\n        return new $calledClass();\n    }\n}\n\nclass Child extends ParentObj {\n    public function __construct() {\n        parent::__construct();\n        // Child class initialization\n    }\n}\n\n// Usage\n$child = Child::factory();