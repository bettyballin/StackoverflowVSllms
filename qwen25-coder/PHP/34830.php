class DogObject {\n    private $isActive = false;\n\n    public function __construct($isActive = false) {\n        $this->isActive = $isActive;\n    }\n\n    public function isActive() {\n        return $this->isActive;\n    }\n}\n\n$dog = new DogObject(false);\nif ($dog->isActive()) {\n   echo "This is bad;";\n} else {\n   echo "Excellent!  The dog object was false!";\n}