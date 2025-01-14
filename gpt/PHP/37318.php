class Database {\n    private $mysqli;\n\n    public function __construct($host, $user, $password, $database) {\n        $this->mysqli = new mysqli($host, $user, $password, $database);\n\n        if ($this->mysqli->connect_error) {\n            die('Connect Error (' . $this->mysqli->connect_errno . ') ' . $this->mysqli->connect_error);\n        }\n    }\n\n    public function query($sql, $params = []) {\n        $stmt = $this->mysqli->prepare($sql);\n        if ($stmt === false) {\n            die('Prepare Error: ' . $this->mysqli->error);\n        }\n\n        if ($params) {\n            $types = str_repeat('s', count($params));\n            $stmt->bind_param($types, ...$params);\n        }\n\n        if (!$stmt->execute()) {\n            die('Execute Error: ' . $stmt->error);\n        }\n\n        $result = $stmt->get_result();\n        if ($result === false) {\n            die('Get Result Error: ' . $stmt->error);\n        }\n\n        $rows = [];\n        while ($row = $result->fetch_assoc()) {\n            $rows[] = $row;\n        }\n\n        $stmt->close();\n        return $rows;\n    }\n\n    public function __destruct() {\n        $this->mysqli->close();\n    }\n}\n\n// Usage example\n$db = new Database('localhost', 'username', 'password', 'database');\n$rows = $db.query('SELECT * FROM users WHERE status = ?', ['active']);\nprint_r($rows);