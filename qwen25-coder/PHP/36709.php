<?php\nclass MyDB {\n    protected $pdo;\n\n    public function __construct($dsn, $user, $pass) {\n        $this->pdo = new PDO($dsn, $user, $pass);\n        $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n    }\n\n    public function find($id) {\n        $stmt = $this->pdo->prepare("SELECT * FROM my_table WHERE id = :id");\n        $stmt->execute([':id' => $id]);\n        return $stmt->fetch(PDO::FETCH_ASSOC);\n    }\n}\n?>