class Set {\n    private $elements;\n\n    public function __construct() {\n        $this->elements = [];\n    }\n\n    public function add($element) {\n        if (!in_array($element, $this->elements)) {\n            $this->elements[] = $element;\n        }\n    }\n\n    public function remove($element) {\n        $index = array_search($element, $this->elements);\n        if ($index !== false) {\n            unset($this->elements[$index]);\n        }\n    }\n\n    public function getElements() {\n        return $this->elements;\n    }\n}