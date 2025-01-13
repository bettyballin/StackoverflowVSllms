class OriginalClass {\n    public $property1;\n    public $property2;\n\n    function __construct($property1, $property2) {\n        $this->property1 = $property1;\n        $this->property2 = $property2;\n    }\n}\n\nclass NewClass extends OriginalClass {\n    function __construct(OriginalClass $originalObject) {\n        $this->property1 = $originalObject->property1;\n        $this->property2 = $originalObject->property2;\n    }\n}\n\n$originalObject = new OriginalClass('value1', 'value2');\n$newObject = new NewClass($originalObject);\n\nprint_r($newObject);