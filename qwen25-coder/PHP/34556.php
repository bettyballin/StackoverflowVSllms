<?php\n\nclass Database {\n    private $host;\n    private $db_name;\n    private $username;\n    private $password;\n    private $conn;\n\n    public function __construct($host, $db_name, $username, $password) {\n        $this->host = $host;\n        $this->db_name = $db_name;\n        $this->username = $username;\n        $this->password = $password;\n    }\n\n    public function connect() {\n        $this->conn = null;\n\n        try {\n            $dsn = "mysql:host=" . $this->host . ";dbname=" . $this->db_name;\n            // Set default PDO error mode to exception\n            $this->conn = new PDO($dsn, $this->username, $this->password);\n            $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n        } catch (PDOException $e) {\n            echo "Connection Error: " . $e->getMessage();\n        }\n\n        return $this->conn;\n    }\n\n    public function query($query, $params = array()) {\n        if (!$this->conn) {\n            $this->connect();\n        }\n\n        $stmt = $this->conn->prepare($query);\n        $stmt->execute($params);\n\n        return $stmt;\n    }\n}\n\n// Usage Example:\n$db = new Database('localhost', 'database_name', 'username', 'password');\n$conn = $db->connect();\n\ntry {\n    $result = $db->query("SELECT * FROM users WHERE id = :id", [':id' => 1]);\n    while ($row = $result->fetch(PDO::FETCH_ASSOC)) {\n        print_r($row);\n    }\n} catch (PDOException $e) {\n    echo "Query Error: " . $e->getMessage();\n}\n\n?>