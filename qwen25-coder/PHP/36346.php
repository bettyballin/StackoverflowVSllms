<?php\nclass Car {\n    // Properties\n    private $color;\n    public $model;\n\n    // Constructor\n    function __construct($color, $model) {\n        $this->color = $color;\n        $this->model = $model;\n    }\n\n    // Method to show car info\n    public function displayInfo() {\n        return "This is a {$this->color} {$this->model}.";\n    }\n}\n\n// Creating an object of the Car class\n$myCar = new Car("red", "Toyota");\n\n// Accessing object properties and methods\necho $myCar->model;          // Outputs: Toyota\necho $myCar->displayInfo();   // Outputs: This is a red Toyota.\n?>