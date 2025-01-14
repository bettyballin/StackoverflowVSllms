class Database {\n    private $pdo;\n\n    public function __construct($dsn, $username, $password, $options = []) {\n        try {\n            $this->pdo = new PDO($dsn, $username, $password, $options);\n            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n        } catch (PDOException $e) {\n            // Handle connection error\n            throw new Exception("Database connection error: " . $e->getMessage());\n        }\n    }\n\n    public function query($sql, $params = []) {\n        try {\n            $stmt = $this->pdo->prepare($sql);\n            $stmt->execute($params);\n            return $stmt->fetchAll(PDO::FETCH_ASSOC);\n        } catch (PDOException $e) {\n            // Handle query error\n            throw new Exception("Database query error: " . $e->getMessage());\n        }\n    }\n\n    public function execute($sql, $params = []) {\n        try {\n            $stmt = $this->pdo->prepare($sql);\n            return $stmt->execute($params);\n        } catch (PDOException $e) {\n            // Handle execution error\n            throw new Exception("Database execution error: " . $e->getMessage());\n        }\n    }\n\n    public function beginTransaction() {\n        return $this->pdo->beginTransaction();\n    }\n\n    public function commit() {\n        return $this->pdo->commit();\n    }\n\n    public function rollBack() {\n        return $this->pdo->rollBack();\n    }\n}\n\n// Example usage:\n$dsn = 'mysql:host=localhost;dbname=testdb';\n$username = 'root';\n$password = 'password';\n\n$db = new Database($dsn, $username, $password);\n\n// Select query\n$results = $db->query('SELECT * FROM users WHERE id = :id', ['id' => 1]);\n\n// Insert query\n$db->execute('INSERT INTO users (name, email) VALUES (:name, :email)', ['name' => 'John Doe', 'email' => 'john@example.com']);