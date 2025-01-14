class Db {\n    private $pdo;\n\n    public function __construct($dsn, $user, $password) {\n        $this->pdo = new PDO($dsn, $user, $password);\n    }\n\n    public function query($sql, $bindings) {\n        $stmt = $this->pdo->prepare($sql);\n        $stmt->execute($bindings);\n        return $stmt->fetchAll(PDO::FETCH_ASSOC);\n    }\n}\n\n// Usage\n$db = new Db($dsn, $user, $password);\n$bindings = array(':name' => $articleName);\n$result = $db->query('SELECT id, name, title, image, content FROM ' . CONFIG_MYSQL_TABLE_PREFIX . 'articles WHERE name = :name LIMIT 1', $bindings);