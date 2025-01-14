class Example {\n    private $property = "I am a property";\n\n    public function showProperty() {\n        // Using $this to refer to the property of the current object instance\n        echo $this->property;\n    }\n}\n\n$exampleObject = new Example();\n$exampleObject->showProperty(); // Outputs: I am a property