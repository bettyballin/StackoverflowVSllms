class User {\n    private $db;\n\n    public function __construct(SimpleDB $db) {\n        $this->db = $db;\n    }\n\n    public function authenticate($username, $password) {\n        $user = $this->db->query("SELECT * FROM users WHERE username = ?", [$username]);\n        if ($user && password_verify($password, $user[0]['password'])) {\n            return true;\n        }\n        return false;\n    }\n}