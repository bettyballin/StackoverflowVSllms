class MyDBClass {\n    public function users() {\n        return new QueryBuilder('users');\n    }\n\n    public function comments() {\n        return new QueryBuilder('comments');\n    }\n}\n\nclass QueryBuilder {\n    private $table;\n    private $conditions = [];\n    private $limit;\n\n    public function __construct($table) {\n        $this->table = $table;\n    }\n\n    public function id($condition) {\n        $this->conditions[] = "id $condition";\n        return $this;\n    }\n\n    public function limit($number) {\n        $this->limit = $number;\n        return $this;\n    }\n\n    public function getSQL() {\n        $sql = "SELECT * FROM {$this->table}";\n        if (!empty($this->conditions)) {\n            $sql .= " WHERE " . implode(' AND ', $this->conditions);\n        }\n        if ($this->limit) {\n            $sql .= " LIMIT {$this->limit}";\n        }\n        return $sql;\n    }\n}\n\n// Usage\n$myDBClass = new MyDBClass();\n$sql1 = $myDBClass->users()->limit(5)->getSQL();\n$sql2 = $myDBClass->comments()->id("> 3")->limit(10)->getSQL();\n\necho $sql1; // Output: SELECT * FROM users LIMIT 5\necho "\n";\necho $sql2; // Output: SELECT * FROM comments WHERE id > 3 LIMIT 10