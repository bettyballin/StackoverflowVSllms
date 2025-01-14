class CustomArray implements ArrayAccess, Iterator, Countable {\n    private $container = [];\n\n    public function __construct(array $array = []) {\n        $this->container = $array;\n    }\n\n    // ArrayAccess methods\n    public function offsetSet($offset, $value) {\n        if (is_null($offset)) {\n            $this->container[] = $value;\n        } else {\n            $this->container[$offset] = $value;\n        }\n    }\n\n    public function offsetExists($offset) {\n        return isset($this->container[$offset]);\n    }\n\n    public function offsetUnset($offset) {\n        unset($this->container[$offset]);\n    }\n\n    public function offsetGet($offset) {\n        return isset($this->container[$offset]) ? $this->container[$offset] : null;\n    }\n\n    // Iterator methods\n    private $position = 0;\n\n    public function rewind() {\n        $this->position = 0;\n    }\n\n    public function current() {\n        return $this->container[$this->position];\n    }\n\n    public function key() {\n        return $this->position;\n    }\n\n    public function next() {\n        ++$this->position;\n    }\n\n    public function valid() {\n        return isset($this->container[$this->position]);\n    }\n\n    // Countable method\n    public function count() {\n        return count($this->container);\n    }\n\n    // Additional methods can be added to enhance functionality\n}