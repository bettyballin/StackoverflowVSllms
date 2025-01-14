<?php\n\nclass DatabaseConnector {\n    private $dbhost = 'xx';\n    private $dbuser = 'xx';\n    private $dbpass = 'xx';\n    private $dbname = 'xx';\n    protected $connection;\n\n    public function __construct() {}\n\n    public function connect() {\n        try {\n            $this->connection = new PDO("mysql:host=$this->dbhost;dbname=$this->dbname", $this->dbuser, $this->dbpass);\n            $this->connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n        } catch (PDOException $e) {\n            die("Database connection failed: " . $e->getMessage());\n        }\n    }\n\n    public function disconnect() {\n        $this->connection = null;\n    }\n\n    public function getConnection() {\n        return $this->connection;\n    }\n}\n\nclass DatabaseInteractions {\n    private $pdo;\n\n    public function __construct(PDO $pdo) {\n        $this->pdo = $pdo;\n    }\n\n    public function search($queryInput) {\n        $stmt = $this->pdo->prepare("SELECT content FROM site_content WHERE content LIKE :query");\n        $query = "%" . $this->pdo->quote($queryInput, PDO::PARAM_STR) . "%";\n        $stmt->bindParam(':query', $query);\n        $stmt->execute();\n        return $stmt->fetchAll(PDO::FETCH_ASSOC);\n    }\n\n    public function getPageContent($pageId) {\n        $stmt = $this->pdo->prepare("SELECT * FROM site_content WHERE page_id = :id");\n        $stmt->bindParam(':id', $pageId, PDO::PARAM_INT);\n        $stmt->execute();\n        return $stmt->fetch(PDO::FETCH_ASSOC);\n    }\n}