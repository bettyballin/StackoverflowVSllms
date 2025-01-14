class Database {\n    private static $instance = null;\n    private $connection;\n\n    private function __construct() {\n        $this->connection = new mysqli("host", "username", "password", "database");\n        if ($this->connection->connect_error) {\n            die("Connection failed: " . $this->connection->connect_error);\n        }\n    }\n\n    public static function getInstance() {\n        if (self::$instance == null) {\n            self::$instance = new Database();\n        }\n        return self::$instance;\n    }\n\n    public function getConnection() {\n        return $this->connection;\n    }\n}\n\n// Usage\n$db = Database::getInstance()->getConnection();