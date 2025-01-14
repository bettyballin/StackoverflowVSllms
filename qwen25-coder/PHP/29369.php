class SomeThing {\n    private array $data;\n\n    public function __construct() {\n        $this->data = [];\n    }\n\n    public function setProperty(string $property, mixed $value): void {\n        $this->data[$property] = $value;\n    }\n\n    public function getProperty(string $property): mixed {\n        return $this->data[$property];\n    }\n}