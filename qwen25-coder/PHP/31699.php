class A {\n    private $name;\n    private $age;\n\n    public function __get($var) {\n        if (property_exists($this, $var)) {\n            if ($var === 'age') {\n                return $this->age + 10; // Custom logic for age\n            }\n            return $this->$var;\n        }\n        throw new Exception("Property {$var} does not exist");\n    }\n\n    public function __set($var, $value) {\n        if (property_exists($this, $var)) {\n            switch ($var) {\n                case 'age':\n                    // Add validation logic here if needed\n                    $this->$var = $value;\n                    break;\n                default:\n                    $this->$var = $value;\n            }\n        } else {\n            throw new Exception("Property {$var} does not exist");\n        }\n    }\n}