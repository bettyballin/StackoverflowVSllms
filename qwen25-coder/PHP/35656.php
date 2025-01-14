class Address {\n    public $Street;\n}\n\nclass Employee {\n    public $ID;\n    public $Name;\n    public $Address;\n}\n\n$myEmployee = new Employee();\n$myEmployee->Address = new Address();\n\n// Accessing the street property\n$street = $myEmployee->Address->Street;\n\necho $street; // This will output the value of Street, or nothing if it's not set.