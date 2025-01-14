// DatabaseFactory.php\ninterface DatabaseFactory {\n    public function createConnection();\n    public function createQueryBuilder();\n}\n\n// MySQLFactory.php\nclass MySQLFactory implements DatabaseFactory {\n    public function createConnection() {\n        return new MySQLConnection();\n    }\n    public function createQueryBuilder() {\n        return new MySQLQueryBuilder();\n    }\n}\n\n// PostgreSQLFactory.php\nclass PostgreSQLFactory implements DatabaseFactory {\n    public function createConnection() {\n        return new PostgreSQLConnection();\n    }\n    public function createQueryBuilder() {\n        return new PostgreSQLQueryBuilder();\n    }\n}