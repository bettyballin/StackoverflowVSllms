class Myclass {\n    private $dbConnection; // Assume this is set up in your constructor\n\n    public function __construct($params) {\n        // Initialize database connection here\n        // Example: $this->dbConnection = new PDO('your_connection_string');\n    }\n\n    public function insertData() {\n        try {\n            $stmt = $this->dbConnection->prepare("INSERT INTO your_table (column1, column2) VALUES (:param1, :param2)");\n            $stmt->bindParam(':param1', $param1);\n            $stmt->bindParam(':param2', $param2);\n\n            // Assume $param1 and $param2 are set from your params\n            $stmt->execute();\n\n            return true; // Return true on success\n        } catch (PDOException $e) {\n            error_log($e->getMessage()); // Log the error for debugging\n            return false; // Return false on failure\n        }\n    }\n}\n\n// Usage\n$foo = new Myclass('my params');\nif ($foo->insertData()) {\n    echo "Insert successful!";\n} else {\n    echo "Insert failed.";\n}