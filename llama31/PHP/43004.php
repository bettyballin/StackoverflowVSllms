class Test {\n    private $attr1;\n    private $attr2;\n\n    public function __construct($attr1, $attr2) {\n        $this->setAttr1($attr1);\n        $this->setAttr2($attr2);\n    }\n\n    public function getAttr1() {\n        return $this->attr1;\n    }\n\n    public function setAttr1($value) {\n        // Validate and sanitize $value\n        $this->attr1 = $value;\n    }\n\n    public function getAttr2() {\n        return $this->attr2;\n    }\n\n    public function setAttr2($value) {\n        // Validate and sanitize $value\n        $this->attr2 = $value;\n    }\n}