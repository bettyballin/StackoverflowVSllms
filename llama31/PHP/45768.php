class Database {\n    private $connection;\n\n    public function __construct() {\n        $this->connection = mysql_connect();\n        mysql_db_select();\n    }\n\n    public function query($sql) {\n        $result = mysql_query($sql);\n        // Handle errors, etc.\n        return $result;\n    }\n\n    public function close() {\n        mysql_close($this->connection);\n    }\n}\n\n$db = new Database();\n$sql = 'SELECT id, title, s_name, created, cat_name, tag_name\n        FROM content\n        JOIN INNER category, cat_id, id\n        WHERE id=1\n        ORDER created';\n$result = $db->query($sql);\n$db->close();