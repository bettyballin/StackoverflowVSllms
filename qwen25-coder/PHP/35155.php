class Foo implements ArrayAccess {\n    private $container = array();\n\n    public function __construct() {}\n\n    // Check if an offset exists.\n    public function offsetExists($offset) {\n        return isset($this->container[$offset]);\n    }\n\n    // Get the value at a specified offset.\n    public function offsetGet($offset) {\n        return isset($this->container[$offset]) ? $this->container[$offset] : null;\n    }\n\n    // Set the value at a specified offset.\n    public function offsetSet($offset, $value) {\n        if (is_null($offset)) {\n            $this->container[] = $value;\n        } else {\n            $this->container[$offset] = $value;\n        }\n    }\n\n    // Unset an element in the array using the specified offset.\n    public function offsetUnset($offset) {\n        unset($this->container[$offset]);\n    }\n}\n\n$foo = new Foo();\n\n$foo['fooKey'] = 'foo value';\n\necho $foo['fooKey']; // Outputs: foo value