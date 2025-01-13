class DatabaseConnection {\n  private static $instance;\n  private $connection;\n\n  private function __construct() {\n    $this->connection = new PDO('mysql:host=localhost;dbname=yourdb', 'username', 'password');\n  }\n\n  public static function getInstance() {\n    if (!self::$instance) {\n      self::$instance = new self();\n    }\n    return self::$instance;\n  }\n\n  public function getConnection() {\n    return $this->connection;\n  }\n\n  public function closeConnection() {\n    $this->connection = null;\n  }\n}