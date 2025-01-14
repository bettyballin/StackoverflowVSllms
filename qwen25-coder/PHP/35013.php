<?php\nclass BlogModel {\n    private $db;\n    \n    public function __construct($db) {\n        $this->db = $db;\n    }\n    \n    public function getBlogs() {\n        $stmt = $this->db->query("SELECT blogs.*, authors.id AS author_id, authors.name FROM blogs JOIN authors ON authors.id = blogs.author");\n        $blogs = [];\n        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n            $author = new Author($row['author_id'], $row['name']);\n            $blog = new Blog($row['id'], $row['title'], $author);\n            $blogs[] = $blog;\n        }\n        return $blogs;\n    }\n}\n\nclass Blog {\n    public $id;\n    public $title;\n    public $author;\n\n    public function __construct($id, $title, Author $author) {\n        $this->id = $id;\n        $this->title = $title;\n        $this->author = $author;\n    }\n\n    // Method to get author\n    public function getAuthor() {\n        return $this->author;\n    }\n}\n\nclass Author {\n    public $id;\n    public $name;\n\n    public function __construct($id, $name) {\n        $this->id = $id;\n        $this->name = $name;\n    }\n}\n?>