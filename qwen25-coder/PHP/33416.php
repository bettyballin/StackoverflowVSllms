class String {\n    private $value;\n\n    public function __construct($string) {\n        $this->value = (string)$string;\n    }\n\n    public function length(): int {\n        return strlen($this->value);\n    }\n\n    public function substring(int $start, int $length = null): string {\n        return substr($this->value, $start, $length);\n    }\n\n    public function toUpperCase(): string {\n        return strtoupper($this->value);\n    }\n\n    public function toLowerCase(): string {\n        return strtolower($this->value);\n    }\n\n    // Add more methods as needed\n}\n\n// Usage example\n$string = new String("Hello, World!");\necho $string->toUpperCase(); // Outputs: HELLO, WORLD!