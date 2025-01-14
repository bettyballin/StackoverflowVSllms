class User {\n    private string $name;\n    private int $id;\n\n    public function __construct(string $name, int $id) {\n        $this->name = $name;\n        $this->id = $id;\n    }\n\n    public function getName(): string {\n        return $this->name;\n    }\n\n    public function getId(): int {\n        return $this->id;\n    }\n}\n\n$user = new User('John Doe', 1);\necho $user->getName(); // Outputs: John Doe\n// There is no way to modify name or id after initializatio