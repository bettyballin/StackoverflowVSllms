class Set {\n    private $elements = [];\n\n    public function add($element) {\n        $this->elements[$element] = true;\n    }\n\n    public function remove($element) {\n        unset($this->elements[$element]);\n    }\n\n    public function contains($element) {\n        return isset($this->elements[$element]);\n    }\n\n    public function getElements() {\n        return array_keys($this->elements);\n    }\n}\n\n// Usage\n$set = new Set();\n$set->add('apple');\n$set->add('banana');\n$set->add('apple'); // Duplicate, won't be added again\n\nprint_r($set->getElements());