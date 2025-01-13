// Example of a simple PHP class\nclass User {\n    private $name;\n    private $email;\n\n    public function __construct($name, $email) {\n        $this->name = $name;\n        $this->email = $email;\n    }\n\n    public function getName() {\n        return $this->name;\n    }\n\n    public function getEmail() {\n        return $this->email;\n    }\n}