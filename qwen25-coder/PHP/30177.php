class SecureDatabase {\n    private $pdo;\n\n    public function __construct($dsn, $user, $password) {\n        $this->pdo = new PDO($dsn, $user, $password);\n    }\n\n    public function exec($sql, $params = []) {\n        $stmt = $this->pdo->prepare($sql);\n        $stmt->execute(array_values($params));\n        return $stmt;\n    }\n}\n\n// Usage\n$DB = new SecureDatabase('mysql:host=localhost;dbname=database', 'user', 'password');\n$userInput1 = $_POST['var_x'];\n$userInput2 = $_POST['another_var'];\n\n$result = $DB->exec("SELECT * FROM table WHERE id = :id AND another_column = :another_column", [\n    ':id' => $userInput1,\n    ':another_column' => $userInput2\n]);