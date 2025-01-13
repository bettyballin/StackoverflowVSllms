class Database {\n  private static $instance;\n  private $mysqli;\n\n  private function __construct() {\n    $this->mysqli = new mysqli('host', 'user', 'pass', 'db');\n  }\n\n  public static function getInstance() {\n    if (!self::$instance) {\n      self::$instance = new Database();\n    }\n    return self::$instance;\n  }\n\n  public function getMysqli() {\n    return $this->mysqli;\n  }\n}