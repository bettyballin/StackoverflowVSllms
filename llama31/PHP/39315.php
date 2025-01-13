class Decorator {\n    private $original;\n\n    public function __construct(Storage $original) {\n        $this->original = $original;\n    }\n\n    public function __get($property) {\n        // Log access to property\n        // ...\n        return $this->original->$property;\n    }\n\n    public function __set($property, $value) {\n        // Log change to property\n        // ...\n        $this->original->$property = $value;\n    }\n}