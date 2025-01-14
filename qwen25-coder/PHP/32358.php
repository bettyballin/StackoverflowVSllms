class MyCustomElement {\n    private $attributes;\n\n    public function __construct(array $attributes) {\n        $this->attributes = $attributes;\n    }\n\n    // Handle attribute access using the [] operator syntax\n    public function &__get($name) {\n        if (array_key_exists($name, $this->attributes)) {\n            return $this->attributes[$name];\n        }\n        throw new Exception("Property '$name' does not exist.");\n    }\n}\n\n// Example usage:\n$element = new MyCustomElement(['id' => '123']);\necho $element->id; // Outputs: 123