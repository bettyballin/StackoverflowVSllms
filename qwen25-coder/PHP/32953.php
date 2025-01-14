<?php\n\ninterface MyInterface {\n    function myFunction($argument); // Accepts array or object implementing Traversable or ArrayAccess\n}\n\nclass MyClass implements \ArrayAccess, \IteratorAggregate {\n    private $container = [];\n\n    public function __constructor(array $array) {\n        $this->container = $array;\n    }\n\n    public function offsetSet($offset, $value) {\n        if (is_null($offset)) {\n            $this->container[] = $value;\n        } else {\n            $this->container[$offset] = $value;\n        }\n    }\n\n    public function offsetExists($offset): bool {\n        return isset($this->container[$offset]);\n    }\n\n    public function offsetUnset($offset) {\n        unset($this->container[$offset]);\n    }\n\n    public function offsetGet($offset) {\n        return isset($this->container[$offset]) ? $this->container[$offset] : null;\n    }\n\n    public function getIterator(): \arrayIterator {\n        return new ArrayIterator($this->container);\n    }\n}\n\nclass MyService implements MyInterface {\n    public function myFunction($argument) {\n        if (!is_array($argument) && !$argument instanceof \Traversable && !$argument instanceof \ArrayAccess) {\n            throw new InvalidArgumentException('Argument must be array or object implementing Traversable/ArrayAccess');\n        }\n\n        // Convert argument to array if necessary\n        if (!$argument instanceof \IteratorAggregate){\n            $argument = iterator_to_array($argument);\n        } elseif (!$argument instanceof \Traversable) {\n            $argument = (array)$argument;\n        }\n\n        // Now you can work with $argument as an array\n        foreach ($argument as $key => $value) {\n            // do something\n        }\n    }\n}\n\n$arrayObject = new MyClass(["key" => "value"]);\n$service = new MyService();\n$service->myFunction($arrayObject); // This will work\n\n?>