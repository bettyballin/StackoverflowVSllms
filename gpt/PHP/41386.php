<?php\nclass MyClass {\n    private $variable;\n\n    // Constructor to initialize the class with a variable\n    public function __construct($variable) {\n        $this->variable = $variable;\n    }\n\n    // Example function that uses the variable\n    public function myFunction() {\n        echo $this->variable;\n    }\n}\n\n// Create an instance of the class and pass the variable\n$instance = new MyClass('Hello, World!');\n$instance->myFunction(); // Outputs: Hello, World!\n?>