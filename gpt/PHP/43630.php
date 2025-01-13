<?php\nclass OriginalClass {\n    var $property1;\n    var $property2;\n\n    function OriginalClass($property1, $property2) {\n        $this->property1 = $property1;\n        $this->property2 = $property2;\n    }\n}\n\nclass SubClass extends OriginalClass {\n    var $additionalProperty;\n\n    function SubClass($property1, $property2, $additionalProperty) {\n        $this->OriginalClass($property1, $property2);\n        $this->additionalProperty = $additionalProperty;\n    }\n}\n\n// Original object\n$originalObject = new OriginalClass('value1', 'value2');\n\n// New subclass object\n$subclassObject = new SubClass($originalObject->property1, $originalObject->property2, 'additionalValue');\n\n// Copy properties from original object to subclass object\n$subclassObject->property1 = $originalObject->property1;\n$subclassObject->property2 = $originalObject->property2;\n\necho $subclassObject->property1; // Outputs: value1\necho $subclassObject->property2; // Outputs: value2\necho $subclassObject->additionalProperty; // Outputs: additionalValue\n?>