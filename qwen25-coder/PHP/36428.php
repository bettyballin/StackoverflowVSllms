class ObjectCollection {\n    private $objects;\n    private $currentIndex;\n\n    public function __construct(array $objects) {\n        $this->objects = $objects;\n        $this->currentIndex = 0;\n    }\n\n    public function getCurrentObject() {\n        if ($this->isValidIndex($this->currentIndex)) {\n            return $this->objects[$this->currentIndex];\n        }\n        return null;\n    }\n\n    public function getNextObject() {\n        if ($this->isValidIndex($this->currentIndex + 1)) {\n            return $this->objects[++$this->currentIndex];\n        }\n        return null;\n    }\n\n    public function getPreviousObject() {\n        if ($this->isValidIndex($this->currentIndex - 1)) {\n            return $this->objects[--$this->currentIndex];\n        }\n        return null;\n    }\n\n    private function isValidIndex($index) {\n        return isset($this->objects[$index]);\n    }\n}\n\n// Example usage\nclass MyObject {\n    public $data;\n\n    public function __construct($data) {\n        $this->data = $data;\n    }\n}\n\n$objects = [new MyObject('First'), new MyObject('Second'), new MyObject('Third')];\n$collection = new ObjectCollection($objects);\n\n$currentObject = $collection->getCurrentObject(); // First\n$nextObject = $collection->getNextObject();       // Second\n$previousObject = $collection->getPreviousObject();// First