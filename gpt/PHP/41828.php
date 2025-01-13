class User {\n    private $data = [];\n\n    public function __set($name, $value) {\n        // Validate and sanitize the value before setting\n        if ($name === 'email') {\n            if (filter_var($value, FILTER_VALIDATE_EMAIL)) {\n                $this->data[$name] = $value;\n            } else {\n                throw new InvalidArgumentException("Invalid email address.");\n            }\n        } else {\n            $this->data[$name] = $value;\n        }\n    }\n\n    public function __get($name) {\n        // Check if the property exists in the data array\n        if (array_key_exists($name, $this->data)) {\n            return $this->data[$name];\n        }\n        // Optionally, handle undefined properties\n        throw new OutOfBoundsException("Property '$name' does not exist.");\n    }\n}\n\n// Usage\n$user = new User();\n$user->email = "example@example.com";\necho $user->email; // Outputs: example@example.com\n\n// This will throw an exception\n// $user->email = "invalid-email";