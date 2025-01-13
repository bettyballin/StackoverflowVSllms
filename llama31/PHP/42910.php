class Container {\n    private $database;\n\n    public function __construct() {\n        $this->database = new Database();\n    }\n\n    public function getDatabase() {\n        return $this->database;\n    }\n}\n\n$container = new Container();\n$article = new Article($container->getDatabase());\n$user = new User($container->getDatabase());