class Car {\n    private $people = array();\n    private $capacity;\n\n    function __construct($capacity) { $this->capacity = $capacity; }\n\n    function addPerson($name) {\n        if(count($this->people) >= $this->capacity) {\n            throw new Exception("Car is already at capacity");\n        } else {\n            $this->people[] = $name;\n        }\n    }\n    function getPeople() { return $this->people; }\n    function getCapacity() { return $this->capacity; }\n}