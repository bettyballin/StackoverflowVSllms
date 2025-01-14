class DbConnection {\n    private $connection;\n\n    public function connectToDatabase() {\n        // establish database connection logic here\n        return $this->connection = new \PDO('your_connection_string');\n    }\n\n    public function closeDatabaseConnection() {\n        $this->connection = null;\n    }\n\n    public function executeQuery($query, $params) {\n        $stmt = $this->connection->prepare($query);\n        $stmt->execute($params);\n        return $stmt->fetchAll();\n    }\n}\n\nclass DbDisplay {\n    private $dbConnection;\n\n    public function __construct(DbConnection $dbConnection) {\n        $this->dbConnection = $dbConnection;\n    }\n\n    public function displayPage() {\n        $query = "SELECT * FROM pages WHERE id = :id";\n        $pageData = $this->dbConnection->executeQuery($query, array(':id' => 1));\n        // Display logic here\n    }\n}\n\nclass DbInsertion {\n    private $dbConnection;\n\n    public function __construct(DbConnection $dbConnection) {\n        $this->dbConnection = $dbConnection;\n    }\n\n    public function newPost($userCredentials, $postTextFromUser) {\n        $query = "INSERT INTO posts (credentials, text) VALUES (:credentials, :text)";\n        return $this->dbConnection->executeQuery($query, array(':credentials' => $userCredentials, ':text' => $postTextFromUser));\n    }\n}\n\n// Usage in index.php\n$dbConnection = new DbConnection();\n$dbConnection->connectToDatabase();\n\n$displayer = new DbDisplay($dbConnection);\n$displayer->displayPage();\n\n$dbConnection->closeDatabaseConnection();\n\n// Usage in userinsert.php\n$usersDbConnection = new DbConnection();\n$usersDbConnection->connectToDatabase();\n\n$inserter = new DbInsertion($usersDbConnection);\n$inserter->newPost('user_credentials', 'Some text here');\n\n$usersDbConnection->closeDatabaseConnection();