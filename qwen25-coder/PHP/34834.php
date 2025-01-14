// Database.php: Data Access Layer\nclass Database {\n    public function query($sql) {\n        // Execute SQL query\n    }\n}\n\n// Post.php: Business Logic/Model Layer\nclass Post {\n    private $db;\n\n    public function __construct(Database $database) {\n        $this->db = $database;\n    }\n\n    public function add($data) {\n        // Add a new post to the database\n        $sql = "INSERT INTO posts (content) VALUES (:content)";\n        return $this->db->query($sql, ['content' => $data['content']]);\n    }\n}\n\n// ViewController.php: Controller Layer\nclass PostController {\n    private $post;\n\n    public function __construct(Post $post) {\n        $this->post = $post;\n    }\n\n    public function handleCreatePost(array $postData) {\n        // Validate and sanitize input\n        if (isset($postData['content']) && !empty(trim($postData['content']))) {\n            return $this->post->add(['content' => trim($postData['content'])]);\n        }\n        throw new Exception("Invalid data");\n    }\n}\n\n// Main Application\ntry {\n    $db = new Database();\n    $postModel = new Post($db);\n    $controller = new PostController($postModel);\n\n    // Simulate receiving POST data\n    $postData = $_POST;\n    $controller->handleCreatePost($postData);\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}