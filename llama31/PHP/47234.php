interface UserDaoInterface\n{\n    public function getUserById($id);\n    public function saveUser(User $user);\n}\n\nclass UserDAO implements UserDaoInterface\n{\n    private $db;\n\n    public function __construct(Database $db)\n    {\n        $this->db = $db;\n    }\n\n    public function getUserById($id)\n    {\n        $query = $this->db->prepare('SELECT * FROM users WHERE id = :id');\n        $query->bindParam(':id', $id);\n        $query->execute();\n        return $query->fetch();\n    }\n\n    public function saveUser(User $user)\n    {\n        // Insert or update user data\n    }\n}