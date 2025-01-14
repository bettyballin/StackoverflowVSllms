// UserModel.php\nclass UserModel {\n    private $db;\n\n    public function __construct(Database $db) {\n        $this->db = $db;\n    }\n\n    public function getUserById($id) {\n        $stmt = $this->db->query("SELECT * FROM users WHERE id = :id", ['id' => $id]);\n        return $stmt->fetch(PDO::FETCH_ASSOC);\n    }\n}