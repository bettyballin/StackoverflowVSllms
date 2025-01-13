class MyDatabaseClass {\n    private $pdo;\n    private $data;\n\n    public function __construct($dsn, $username, $password) {\n        $this->pdo = new PDO($dsn, $username, $password);\n        // Fetch some data and store it in $data\n        $stmt = $this->pdo->query('SELECT * FROM some_table');\n        $this->data = $stmt->fetchAll(PDO::FETCH_ASSOC);\n    }\n\n    public function __sleep() {\n        // Return an array of property names to serialize, excluding the PDO object\n        return ['data'];\n    }\n\n    public function __wakeup() {\n        // Optionally, reinitialize the PDO object if needed\n        // $this->pdo = new PDO($dsn, $username, $password);\n    }\n\n    // Other methods for manipulating $data and interacting with the database\n}\n\n// Example usage\n$obj = new MyDatabaseClass($dsn, $username, $password);\n$serializedObj = serialize($obj);\n$unserializedObj = unserialize($serializedObj);