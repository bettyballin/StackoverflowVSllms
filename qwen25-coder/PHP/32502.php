class Example {\n    private $name;\n\n    public function name($value = null) {\n        if ($value !== null) {\n            // Setter logic\n            $this->setName($value);\n        } else {\n            // Getter logic\n            return $this->getName();\n        }\n    }\n\n    private function setName($value) {\n        // Validation or other business logic can go here\n        $this->name = $value;\n    }\n\n    private function getName() {\n        return $this->name;\n    }\n}\n\n// Usage:\n$object = new Example();\n$object->name('John Doe'); // Sets the name to "John Doe"\necho $object->name(); // Outputs: John Doe