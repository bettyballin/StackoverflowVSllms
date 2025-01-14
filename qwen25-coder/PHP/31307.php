// Example of using Encapsulate Fields in PhpStorm\n\nBefore:\nclass MyClass {\n    private $myProperty;\n}\n\nAfter applying Encapsulate Fields on 'myProperty':\nclass MyClass {\n    private $myProperty;\n\n    public function getMyProperty() {\n        return $this->myProperty;\n    }\n\n    public function setMyProperty($value) {\n        $this->myProperty = $value;\n    }\n}