class Database {\n    private static $instance;\n    private $connection;\n\n    private function __construct() {}\n\n    public static function getInstance() {\n        if (self::$instance === null) {\n            self::$instance = new Database();\n            self::$instance->connect();\n        }\n        return self::$instance;\n    }\n\n    private function connect() {\n        $this->connection = new mysqli('localhost', 'root', '', 'blog_db');\n        if ($this->connection->connect_error) {\n            die("Connection failed: " . $this->connection->connect_error);\n        }\n    }\n\n    public function getConnection() {\n        return $this->connection;\n    }\n}\n\nclass UserAuth {\n    private static $instance;\n\n    private $dbConnection;\n\n    private function __construct(Database $database) {\n        $this->dbConnection = $database;\n    }\n\n    public static function getInstance() {\n        if (self::$instance === null) {\n            self::$instance = new UserAuth(Database::getInstance());\n        }\n        return self::$instance;\n    }\n\n    public function isLoggedIn($userId) {\n        // Use $this->dbConnection to interact with the database\n        return true; // Simplified for demonstration\n    }\n}\n\n// Usage\n$userAuth = UserAuth::getInstance();\n$isLogged = $userAuth->isLoggedIn(1);