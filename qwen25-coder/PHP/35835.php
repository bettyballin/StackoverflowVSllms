class Database {\n    private static $instance = null;\n    private $pdo;\n\n    // Private constructor to prevent instantiation from outside the class.\n    private function __construct($dsn, $username, $password) {\n        try {\n            $this->pdo = new PDO($dsn, $username, $password);\n            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n        } catch (PDOException $e) {\n            die("Could not connect to the database " . $e->getMessage());\n        }\n    }\n\n    // Public method for getting an instance of the class.\n    public static function getInstance($dsn = null, $username = null, $password = null) {\n        if (!self::$instance) {\n            if (!$dsn || !$username || !$password) {\n                throw new Exception("Missing database configuration parameters.");\n            }\n            self::$instance = new Database($dsn, $username, $password);\n        }\n\n        return self::$instance->pdo;\n    }\n}\n\n// Usage\n$dsn = 'mysql:host=localhost;dbname=testdb';\n$username = 'root';\n$password = '';\n\n$db = Database::getInstance($dsn, $username, $password);\n\ntry {\n    // Run your queries using $db.\n    echo "Connection successful!";\n} catch (Exception $e) {\n    echo "An error occurred: " . $e->getMessage();\n}