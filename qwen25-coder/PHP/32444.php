class CustomArray implements ArrayAccess, IteratorAggregate, Countable {\n    private $container = [];\n\n    public function __construct() {}\n\n    public function offsetSet($offset, $value) {\n        if (is_null($offset)) {\n            $this->container[] = $value;\n        } else {\n            $this->container[$offset] = $value;\n        }\n    }\n\n    public function offsetExists($offset): bool {\n        return isset($this->container[$offset]);\n    }\n\n    public function offsetUnset($offset) {\n        unset($this->container[$offset]);\n    }\n\n    public function offsetGet($offset): mixed {\n        return isset($this->container[$offset]) ? $this->container[$offset] : null;\n    }\n\n    public function getIterator(): Traversable {\n        return new ArrayIterator($this->container);\n    }\n\n    public function count(): int {\n        return count($this->container);\n    }\n}