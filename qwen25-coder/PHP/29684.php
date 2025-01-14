// Data Access Object (DAL)\nclass UserDAO {\n    private $db;\n\n    public function __construct($db) {\n        $this->db = $db; // Assume DB connection is passed here\n    }\n\n    public function getUserById($id) {\n        // Fetch user from the database\n        $stmt = $this->db->prepare("SELECT * FROM users WHERE id = :id");\n        $stmt->execute([':id' => $id]);\n        return $stmt->fetch(PDO::FETCH_ASSOC);\n    }\n}\n\n// Model\nclass UserModel {\n    private $dao;\n\n    public function __construct(UserDAO $dao) {\n        $this->dao = $dao;\n    }\n\n    public function getDisplayName($userId) {\n        $user = $this->dao->getUserById($userId);\n        return ucfirst($user['first_name']) . ' ' . ucfirst($user['last_name']);\n    }\n}