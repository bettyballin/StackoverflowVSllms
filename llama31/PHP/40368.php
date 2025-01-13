use Doctrine\DBAL\Connection;\n\nclass Database\n{\n    private $connection;\n\n    public function __construct(Connection $connection)\n    {\n        $this->connection = $connection;\n    }\n\n    public function query($query_string)\n    {\n        $stmt = $this->connection->prepare($query_string);\n        $stmt->execute();\n        return $stmt->fetchAll();\n    }\n}