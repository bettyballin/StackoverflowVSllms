class String {\n    private $value;\n\n    public function __construct($value) {\n        $this->value = $value;\n    }\n\n    public function length() {\n        return strlen($this->value);\n    }\n\n    public function substr($start, $length) {\n        return substr($this->value, $start, $length);\n    }\n}