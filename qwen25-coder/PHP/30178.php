class Database {\n    private $mysqli;\n\n    public function __construct($host, $user, $password, $database) {\n        $this->mysqli = new mysqli($host, $user, $password, $database);\n        if ($this->mysqli->connect_error) {\n            die("Connection failed: " . $this->mysqli->connect_error);\n        }\n    }\n\n    public function escapeValues(array $values) {\n        return array_map([$this->mysqli, 'real_escape_string'], $values);\n    }\n\n    public function exec($sql, $params = []) {\n        if (!empty($params)) {\n            // Escape user inputs\n            $escapedParams = $this->escapeValues($params);\n            // Replace placeholders in the SQL query with escaped values\n            foreach ($escapedParams as $param) {\n                $position = strpos($sql, '?');\n                if ($position !== false) {\n                    $sql = substr_replace($sql, "'" . $param . "'", $position, 1);\n                } else {\n                    break; // More params than placeholders or no placeholders left\n                }\n            }\n        }\n        return $this->mysqli->query($sql);\n    }\n\n    public function close() {\n        if ($this->mysqli) {\n            $this->mysqli->close();\n        }\n    }\n}\n\n// Usage\n$DB = new Database('localhost', 'user', 'password', 'database');\n$userInput1 = $_POST['var_x'];\n$userInput2 = $_POST['another_var'];\n\n$result = $DB->exec("SELECT * FROM table WHERE id = ? AND another_column = ?", [$userInput1, $userInput2]);